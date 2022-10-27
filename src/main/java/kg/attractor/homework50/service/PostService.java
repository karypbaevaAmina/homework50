package kg.attractor.homework50.service;

import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dto.PostImageDto;
import kg.attractor.homework50.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostDao postDao;


    public Optional<?> createPost(MultipartFile image, String description) {
        return Optional.of(postDao.save(
                        PostImageDto.builder()
                                .image(image)
                                .description(description)
                                .build()
                )
        );
    }


    public Post deletePostById (int id){
        return postDao.deletePost(id);
    }


    public Post findPost (String email){
        return postDao.getPostByUser(email);
    }









}