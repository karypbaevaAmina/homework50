package kg.attractor.homework50.controller;

import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.service.Lesson51Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/database")
@RequiredArgsConstructor
public class PostController {

    private final Lesson51Service service;

    @GetMapping("/post/{email}")
    public ResponseEntity<Post> getPostByUser(@PathVariable String email) {
        return new ResponseEntity<>(service.findPost(email), HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public Post deletePost(@RequestParam Long id) {  //удаление подписки через идентификатор и почту
        return service.deletePostById(id);
    }




}
