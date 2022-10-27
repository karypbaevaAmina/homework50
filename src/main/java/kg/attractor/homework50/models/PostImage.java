package kg.attractor.homework50.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostImage {
    private Long id;
    private String name;
    private String image;


    public PostImage(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
