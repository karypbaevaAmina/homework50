package kg.attractor.homework50.models;

import lombok.Getter;
import lombok.Setter;
import java.time.format.DateTimeFormatter;


@Getter
@Setter

public class Publication {
    private String imageLink;

    private String description;

    private DateTimeFormatter publicationDateTime;


    public Publication(String imageLink, String description, DateTimeFormatter publicationDateTime) {
        this.imageLink = imageLink;
        this.description = description;
        this.publicationDateTime = publicationDateTime;
    }
}
