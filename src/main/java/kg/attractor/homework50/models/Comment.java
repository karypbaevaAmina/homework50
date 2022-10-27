package kg.attractor.homework50.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Comment {

    private int id;
    private String text;
    private LocalDateTime commentDate;

}



