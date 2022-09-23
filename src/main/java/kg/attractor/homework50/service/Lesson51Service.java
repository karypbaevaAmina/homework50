package kg.attractor.homework50.service;

import kg.attractor.homework50.dao.UserDao;
import kg.attractor.homework50.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Lesson51Service {

    private final DBService dbService;
    private final UserDao userDao;

    private int executeUpdate(String query) throws SQLException {
        Statement statement = dbService.getConn().createStatement();
        // Для Insert, Update, Delete
        return statement.executeUpdate(query);
    }

    private void createUserTable() throws SQLException {
        String userTableQuery = "CREATE TABLE users " +
                "(id INTEGER PRIMARY KEY" + "name TEXT" + "accountName TEXT, " + "email TEXT)";
        String userEntryQuery = "INSERT INTO users " +
                "VALUES (1, 'Kim', 'Kimmi', 'kk@mail.ru')";

        executeUpdate(userTableQuery);
        executeUpdate(userEntryQuery);
    }

    public String shouldCreateTable(){
        try{
            createUserTable();
            dbService.getConn().createStatement().execute("select  * from users");
            return  "All it's OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String shouldSelectData(){
        try{
            String query = "select * from users where name= ?";
            PreparedStatement statement = dbService.getConn().prepareStatement(query);
            statement.setString(1, "Kimm");

            if (statement.execute()){
//                return "All it's OK";
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                String name = resultSet.getString("name");
                return  String.format("Name %s ",name);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e){
            return  e.getMessage();
        }
    }

    public List<User> getlUsers(){
        return userDao.getAllUsers();
    }


    public User getUsersByName(String name){
        return userDao.getByName(name);
    }

    public User getUserByAccountName(String accountName){
        return userDao.getByAccountName(accountName);
    }





}
