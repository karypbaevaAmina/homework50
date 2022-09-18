package kg.attractor.homework50.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {

    private String accountName;

    private String email;

    private String password;

    private  int publicCounts;

    public User(String accountName, String email, String password, int publicCounts) {
        this.accountName = accountName;
        this.email = email;
        this.password = password;
        this.publicCounts = publicCounts;
    }


}