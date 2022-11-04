package kg.attractor.homework50.dto;

import kg.attractor.homework50.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PostDto {
    public static PostDto from(PostDto post) {

        return builder()
                .id(post.getId())
                .image(post.getImage())
                .description(post.getDescription())
                .build();
    }

    private int id;
    private String image;
    private String description;

    public PostDto(String image, String description) {
        this.image = image;
        this.description = description;
    }
}

