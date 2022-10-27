package kg.attractor.homework50.dao;

import kg.attractor.homework50.dto.PostDto;
import kg.attractor.homework50.dto.PostImageDto;
import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.util.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
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



    public List<PostImageDto> findAll() {
        String sql5 = "select * " +
                "from post_image ";
        return (List<PostImageDto>) jdbcTemplate.queryForObject(sql5, new BeanPropertyRowMapper<>(PostImageDto.class));
    }



    public PostDto save(PostImageDto image) {
        String sql = "insert into post_image(image, description ) " +
                "values(?,?)";
        String fileName = FileUtil.createFileFromMultipartFile(
                image.getImage(),
                image.getDescription());


        jdbcTemplate.update(sql, fileName, image.getDescription());

        return PostDto.builder()
                .image(fileName)
                .description(image.getDescription())
                .build();
    }

    public Optional<PostImageDto> findByName(String image) {
        String sql = "select * " +
                "from post_image " +
                "where image = ?";
        return Optional.ofNullable(DataAccessUtils.singleResult(
                jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PostImageDto.class), image)
        ));
    }




}

