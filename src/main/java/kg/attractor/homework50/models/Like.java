package kg.attractor.homework50.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Like {

    private int id;
    private User userName;
    private Post markName;
    private DateTimeFormatter markDateTime;

}
