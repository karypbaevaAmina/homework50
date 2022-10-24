package kg.attractor.homework50.dto;

import kg.attractor.homework50.models.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostDto {
    private int id;
    private String image;
    private String description;
    private LocalDateTime publicationDateTime;
    private User user;

}

