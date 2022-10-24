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

    @JsonProperty("poster_data")
    private byte[] posterData;


    public PostImage generateNoImage(){
        return PostImage.builder().name("-no-image").build();
    }
}
