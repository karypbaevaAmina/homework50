package kg.attractor.homework50.util;


import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dao.UserDao;
import kg.attractor.homework50.models.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@AllArgsConstructor
@Configuration

public class InitDataBase {

    private final PostDao postDao;


    private  final UserDao userDao;
    private final PasswordEncoder encoder;
    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {
//            subscriptionDao.deleteAll();
//            eventDao.deleteAll();
//
//            eventDao.save(Event.builder().name("Make the shelter").description("Make it sturdy").eventDate(LocalDateTime.now().minusDays(1)).build());
//            eventDao.save(Event.builder().name("Repair the shelter").description("Make it safe and cozy.").eventDate(LocalDateTime.now().plusDays(1)).build());
//            eventDao.save(Event.builder().name("Gather some firewood").description("To keep the fireplace running").eventDate(LocalDateTime.now().plusDays(1)).build());
//            eventDao.save(Event.builder().name("Winter is coming!").description("Survive the winter!").eventDate(LocalDateTime.now().plusDays(1)).build());


            userDao.deleteAll();

            User user1 = new User();

            user1.setEmail("test@test");
            user1. setName("test");
            user1.setPassword(encoder.encode("test"));
            userDao.save(user1);

            User user2 = new User();

            user2.setEmail("guest@test");
            user2.setName("guest");
            user2.setPassword(encoder.encode("guest"));
            userDao.save(user2);

            User user3 = new User();

            user3.setEmail("admin@test");
            user3.setName("admin");
            user3.setPassword(encoder.encode("admin"));
            userDao.save(user3);



        };
    }


}
