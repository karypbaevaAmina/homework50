package kg.attractor.homework50.models;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;


@Getter
@Setter

public class Comment {

    private String commentText;
    private DateTimeFormatter commentDateTime;

    public Comment(String commentText, DateTimeFormatter commentDateTime) {
        this.commentText = commentText;
        this.commentDateTime = commentDateTime;
    }

}



