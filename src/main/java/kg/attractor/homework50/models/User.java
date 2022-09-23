package kg.attractor.homework50.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String accountName;
    private String email;
    private String password;
    private  int publicCounts;

}