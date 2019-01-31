package edu.adrianKozlowski.forum;

import edu.adrianKozlowski.forum.entity.User;
import edu.adrianKozlowski.forum.service.impl.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserServiceImpl userService) {
        return (args)->{
            User user = new User();
            user.setEmail("darthir@onet.eu");
            user.setUsername("root");
            user.setPassword("Root12#$");
            userService.create(user);
        };

    }

}
