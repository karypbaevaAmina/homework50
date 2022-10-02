package kg.attractor.homework50.models;

import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Post {

    private int id;
    private String link;
    private String description;
    private LocalDateTime publicationDateTime;
    private User user;



}
