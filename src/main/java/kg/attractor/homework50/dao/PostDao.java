package kg.attractor.homework50.dao;

import kg.attractor.homework50.dto.PostDto;
import kg.attractor.homework50.dto.PostImageDto;
import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.util.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@AllArgsConstructor
public class PostDao {



    private final JdbcTemplate jdbcTemplate;



    public Post deletePost(int id) {
        String sql = "delete from posts " +
                "where id = ?; ";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Post.class), id);
    }

    public Post getPostByUser(String email) {
        String sql3 = "select*\n" +
                "from posts\n" +
                "where email = ?; ";
        return jdbcTemplate.queryForObject(sql3, new BeanPropertyRowMapper<>(Post.class), email);
    }

    public Optional<PostImageDto> findById(Long id) {
        String sql = "select * " +
                "from posts " +
                "where id = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostImageDto.class), id)
        ));
    }



    public Long save(PostImageDto image) {
        String sql = "insert into post_image(image, description ) " +
                "values(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(2, image.getDescription());
            ps.setBytes(1, image.getPosterData());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }
}

