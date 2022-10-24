package kg.attractor.homework50.controller;

import kg.attractor.homework50.dto.PostImageDto;
import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

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

    @PostMapping()

    /* Пост отправляется в виде form_data
            image   ->   (файл)
            description  ->  (текст)
     */
    public PostImageDto addPost(@RequestPart MultipartFile file, @RequestPart String description) {
        return postService.addImage(file, description);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Resource> serverFile(@PathVariable Long id) {
        Resource resource = postService.getById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE)
                .body(resource);
    }





}
