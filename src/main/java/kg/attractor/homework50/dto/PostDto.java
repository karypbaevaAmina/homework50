package kg.attractor.homework50.dto;

import kg.attractor.homework50.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private int id;
    private String link;
    private String description;
    private User user;

}
