package kg.attractor.homework50.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentDao {

    private final JdbcTemplate jdbcTemplate;

}
