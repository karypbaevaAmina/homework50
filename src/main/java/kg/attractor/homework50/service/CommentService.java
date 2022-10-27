package kg.attractor.homework50.service;

import kg.attractor.homework50.dao.CommentDao;
import kg.attractor.homework50.dto.CommentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentDao commentDao;


    public CommentDto addComment (String text) {
        CommentDto comment = CommentDto
                .builder()
                .text(text)
                .time(LocalDateTime.now())
                .build();


        var savedComment = commentDao.save(comment);

        return CommentDto.builder()
                .id(Math.toIntExact(savedComment))
                .text(text)
                .time(LocalDateTime.now())
                .build();

    }
}
