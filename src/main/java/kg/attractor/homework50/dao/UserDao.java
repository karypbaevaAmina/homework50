package kg.attractor.homework50.dao;

import kg.attractor.homework50.dto.UserDto;
import kg.attractor.homework50.models.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public String createNewUser(User user) {
        if (!ifExists(user)) {
            String query = "INSERT INTO users(name, email, password, enabled)\n" +
                    "VALUES(?, ?, ?, true)";
            var us = jdbcTemplate.update(query,
                   user.getName(), user.getEmail(), encoder.encode(user.getPassword()));
//            createAuthority(user.getName());
            return "Регистрация прошла успешно!";
        }
        return "Такое имя пользователя или электронная почта существует!";
    }

    public boolean ifExistsUsername(String name) {
        String query = "select count(id) from users\n" +
                "where name = ?";
        var result = jdbcTemplate.queryForObject(query, Integer.class, name);
        return result == 1;
    }

    public boolean ifExistsEmail(String email) {
        String query = "select count(id) from users\n" +
                "where email = ?";
        var result = jdbcTemplate.queryForObject(query, Integer.class, email);
        return result == 1;
    }


    private boolean ifExists(User user) {
        if (ifExistsEmail(user.getEmail()))
            return true;
        if (ifExistsUsername(user.getName()))
            return true;
        return false;
    }

    private void createAuthority(String name) {
        var user = getByName(name);
        String query = "INSERT INTO authorities(user, authority)" +
                "VALUES(?, 'ROLE_USER')";
        jdbcTemplate.update(query, user);
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
        String sql3 = "select email\n" +
                "from users\n" +
                "where name =?; ";
        return jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(User.class), name);
    }


    public Optional<User> findByEmail(String email) {
        String sql3 = "select*\n" +
                "from users\n" +
                "where email =?; ";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(User.class), email));
    }


    public User getByEmail(String email) {
        String sql3 = "select *\n" +
                "from users\n" +
                "where email =?; ";
        return jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(User.class), email);
    }
}


