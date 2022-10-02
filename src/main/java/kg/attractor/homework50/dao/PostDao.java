package kg.attractor.homework50.dao;

import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.models.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Objects;
@Component
@AllArgsConstructor
public class PostDao {

    private final JdbcTemplate jdbcTemplate;

    public int createPost(Post post){
        String sql = "insert into post" +
                "values (?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(conn->{
            PreparedStatement ps=conn.prepareStatement(sql, new String[]{"id"});
            ps.setInt(1, post.getId());
            ps.setString(2, post.getLink());
            ps.setString(3, post.getDescription());
            ps.setTimestamp(4, Timestamp.valueOf(post.getPublicationDateTime()));
            ps.setObject(5, post.getUser());
            return ps;

        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();

    }

//    public Post getPostByUser(String email) {
//        String sql3 = "select* \n" +
//                "from posts \n" +
//                "where user =?; ";
//        return jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(Post.class), email);
//    }



}
