package kg.attractor.homework50.dto;

import kg.attractor.homework50.models.User;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDto extends User {

    private String name;
    private String email;
    private String password;

}

