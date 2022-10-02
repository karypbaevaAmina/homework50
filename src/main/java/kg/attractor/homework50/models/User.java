package kg.attractor.homework50.models;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {


    private Long id;
    private String name;
    private String email;
    private String password;
    private  int publicCounts;
    private  int countBy;
    private  int countIn;


}