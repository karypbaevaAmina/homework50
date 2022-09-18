package kg.attractor.homework50.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Subscription {

    private  String signAccountName;

    private  String signingUpFor;

    private LocalDate eventDate;

    public Subscription(String signAccountName, String signingUpFor, LocalDate eventDate) {
        this.signAccountName = signAccountName;
        this.signingUpFor = signingUpFor;
        this.eventDate = eventDate;
    }
}
