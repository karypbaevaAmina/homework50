package kg.attractor.homework50.dao;

import kg.attractor.homework50.models.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = "insert into users (name, email, password)" +
                "values (?,?,?);";
        jdbcTemplate.update(sql,user.getName(), user.getEmail(),user.getPassword());

    }

    public void deleteAll() {
        String sql = "delete from users;";
        jdbcTemplate.update(sql);
    }

    public List<User> getAllUsers() {
        String query = "select * from users;";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));

    }

    public User getByName(String name) {
        String sql = "select*\n" +
                "from users\n" +
                "where name =?; ";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), name);
    }


    public User getByAccount(String account_name) {
        String sql1 = "select*\n" +
                "from users\n" +
                "where account_name =?; ";
        return jdbcTemplate.queryForObject(sql1, new BeanPropertyRowMapper<>(User.class), account_name);
    }

    public User getByEmail(String email) {
        String sql3 = "select*\n" +
                "from users\n" +
                "where email =?; ";
        return jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(User.class), email);
    }


    public Optional<User> findByEmail(String email) {
        String sql3 = "select*\n" +
                "from users\n" +
                "where email =?; ";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(User.class), email));
    }



}


