package kg.attractor.homework50.service;

import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dto.PostImageDto;
import kg.attractor.homework50.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDao postDao;


    public PostImageDto addImage(MultipartFile file, String description) {
        byte[] data = new byte[0];
        try {
            data = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (data.length == 0) {
            // TODO return no content or something or throw exception
            //  which will be processed on controller layer
        }

        PostImageDto image = PostImageDto
                .builder()
                .posterData(data)
                .description(description)
                .build();

        var savedPostId = postDao.save(image);

        return PostImageDto.builder()
                .id(savedPostId)
                .description(description)
                .posterData(data)
                .build();

    }


    public Post deletePostById (int id){
        return postDao.deletePost(id);
    }


    public Post findPost (String email){
        return postDao.getPostByUser(email);
    }


    public Resource getById(Long id) {
        PostImageDto postImage = postDao.findById(id)
                .orElseThrow(() -> new NotFoundException("Image with " + id + " doesn't exists!"));
        return new ByteArrayResource(postImage.getPosterData());
    }
}