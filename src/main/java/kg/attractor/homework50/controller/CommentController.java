package kg.attractor.homework50.controller;


import kg.attractor.homework50.dto.CommentDto;
import kg.attractor.homework50.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;


    @PostMapping()

    /* Пост отправляется в виде form_data
            text   ->   (text)
     */
    public CommentDto addComment (@RequestPart String text) {
        return service.addComment(text);
    }
}
