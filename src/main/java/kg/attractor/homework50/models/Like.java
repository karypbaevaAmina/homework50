package kg.attractor.homework50.models;

import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter

public class Like {

    private String userAccountName;

    private String markName;

    private DateTimeFormatter markDateTime;

    public Like(String userAccountName, String markName, DateTimeFormatter markDateTime) {
        this.userAccountName = userAccountName;
        this.markName = markName;
        this.markDateTime = markDateTime;
    }
}
