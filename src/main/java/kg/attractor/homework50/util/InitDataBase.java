package kg.attractor.homework50.util;


import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dao.UserDao;
import kg.attractor.homework50.models.Post;
import kg.attractor.homework50.models.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration

public class InitDataBase {

    private  final UserDao userDao;
    private final PostDao postDao;
    private final PasswordEncoder encoder;
    @Bean
    public CommandLineRunner fillData() {
        return (args) -> {


//            postDao.deletePost();

            userDao.deleteAll();

            User user1 = new User();
            user1.setEmail("admin@test");
            user1.setName("admin");
            user1.setPassword(encoder.encode("admin"));
            userDao.save(user1);

            User user2 = new User();

            user2.setEmail("john@test");
            user2.setName("John");
            user2.setPassword(encoder.encode("9876"));
            userDao.save(user2);

            User user3 = new User();

            user3.setEmail("zena@zip");
            user3.setName("Zendeya");
            user3.setPassword(encoder.encode("voov12"));
            userDao.save(user3);


            User user4 = new User();

            user4.setEmail("tom@mail.ru");
            user4.setName("Tomas");
            user4.setPassword(encoder.encode("tom95"));
            userDao.save(user4);


            User user5 = new User();

            user5.setEmail("sara@mail.ru");
            user5.setName("Sara");
            user5.setPassword(encoder.encode("2103pop"));
            userDao.save(user5);


            User user6 = new User();

            user6.setEmail("kim@kim");
            user6. setName("Kimm");
            user6.setPassword(encoder.encode("123"));
            userDao.save(user6);

        };
    }


}
