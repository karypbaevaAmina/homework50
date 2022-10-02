package kg.attractor.homework50.controller;

import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.models.User;
import kg.attractor.homework50.service.DBService;
import kg.attractor.homework50.service.Lesson51Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/database")
@RequiredArgsConstructor
public class PostController {

    private final Lesson51Service service;

//    @GetMapping("/post/{email}")
//    public ResponseEntity<Post> getPostByUser(@PathVariable String email) {
//        return new ResponseEntity<>(service.getALLByUser(email), HttpStatus.OK);
//    }
}
