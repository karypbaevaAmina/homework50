package kg.attractor.homework50.models;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Post {

    private int id;
    private String image;
    private String description;
    private LocalDateTime publicationDateTime;
    private int user;



}
