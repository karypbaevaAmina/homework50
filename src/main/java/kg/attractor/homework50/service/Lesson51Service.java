package kg.attractor.homework50.service;

import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dao.UserDao;
import kg.attractor.homework50.dto.PostDto;
import kg.attractor.homework50.dto.UserDto;
import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        String userTableQuery = "CREATE TABLE users2 " +
                "(id INTEGER PRIMARY KEY" + "name TEXT" + "accountName TEXT, " + "email TEXT)";
        String userEntryQuery = "INSERT INTO users2 " +
                "VALUES (1, 'Kim', 'Kimmi', 'kk@mail.ru')";

        executeUpdate(userTableQuery);
        executeUpdate(userEntryQuery);
    }

    public String shouldCreateTable() {
        try {
            createUserTable();
            dbService.getConn().createStatement().execute("select  * from users2");
            return "All it's OK";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String shouldSelectData() {
        try {
            String query = "select * from users where name= ?";
            PreparedStatement statement = dbService.getConn().prepareStatement(query);
            statement.setString(1, "Kimm");

            if (statement.execute()) {
//                return "All it's OK";
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                String name = resultSet.getString("name");
                return String.format("Name %s ", name);
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public List<User> getlUsers() {
        return userDao.getAllUsers();
    }

    public User getUsersByName(String name) {
            return userDao.getByName(name);

    }

    public User getUserByEmail(String email){
        return userDao.getByEmail(email);
    }




}
