package kg.attractor.homework50.dao;

import kg.attractor.homework50.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;

@Component
@AllArgsConstructor
public class CommentDao {

    private final JdbcTemplate jdbcTemplate;


    public Long save(CommentDto comment) {
        String sql = "insert into comment (text, time ) " +
                "values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, comment.getText());
            ps.setTimestamp(2, Timestamp.valueOf(comment.getTime()));
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

}
