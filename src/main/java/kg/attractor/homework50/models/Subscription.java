package kg.attractor.homework50.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    private int id;
    private  User signAccountName;
    private  User signingUpFor;
    private LocalDate eventDate;


}
