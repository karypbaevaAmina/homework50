package kg.attractor.homework50.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Service
public class DBService {

    @Getter
    private Connection conn;

    public  DBService(){
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getNewConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=qwerty";
        return DriverManager.getConnection(url);

    }

    private  void init()throws  SQLException{
        conn = getNewConnection();
    }

    private  void close() throws SQLException{
        conn.close();
    }


    public String openConnection(){
        try{
            init();
            return "Connecting to the database was successful";
        } catch (SQLException e) {
            return  e.getMessage();
        }
    }






}
