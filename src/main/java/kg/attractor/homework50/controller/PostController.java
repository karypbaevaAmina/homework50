package kg.attractor.homework50.controller;

import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dto.PostImageDto;
import kg.attractor.homework50.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostDao postDao;

 //***************** не нужный код ********////////
//
//    @GetMapping("/post/{email}")
//    public ResponseEntity<Post> getPostByUser(@PathVariable String email) {  //поиск публикации
//        return new ResponseEntity<>(postService.findPost(email), HttpStatus.OK);
//    }
//
//    @DeleteMapping ("/delete/{id}")
//    public Post deletePost(@RequestParam int id) {  //удаление подписки через идентификатор и почту
//        return postService.deletePostById(id);
//
//    }
    ////////********************************************/////////////

    @PostMapping

    /* Пост отправляется в виде form_data
            image   ->   (файл)
            description  ->  (текст)
     */
    public ResponseEntity<?> addPost(@RequestPart MultipartFile image, @RequestPart String description) {
        var post = postService.createPost(image, description);
        return post.isPresent()?
                new ResponseEntity<>(post.get(), HttpStatus.OK):
                new ResponseEntity<>("Вы должны войти в аккаунт, чтобы добавить пост!", HttpStatus.CONFLICT);
    }


    @PostMapping("/post/{image}")
    public ResponseEntity<?> getImageDetails(@PathVariable (value = "image") String image) {
        return new ResponseEntity<>(postDao.findByName(image), HttpStatus.OK);

    }






}
