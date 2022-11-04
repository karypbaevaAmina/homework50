package kg.attractor.homework50.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Getter
@Setter

public class PostImageDto {

    private MultipartFile image;
    private String description;


}
