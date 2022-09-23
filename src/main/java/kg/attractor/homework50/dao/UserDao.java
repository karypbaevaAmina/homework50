package kg.attractor.homework50.dao;

import kg.attractor.homework50.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers(){

        String query = "select * from users;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));

    }

    public User getByName(String name){
        String sql= "select*\n" +
                "from users\n" +
                "where name =?; ";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), name);
    }
}
