package edu.adrianKozlowski.forum;

import edu.adrianKozlowski.forum.entity.Role;
import edu.adrianKozlowski.forum.entity.User;
import edu.adrianKozlowski.forum.entity.repository.RoleRepository;
import edu.adrianKozlowski.forum.service.impl.RoleServiceImpl;
import edu.adrianKozlowski.forum.service.impl.UserServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Bean
    InitializingBean sendDatabase() {
        return ()->{
            Role role2= new Role("ADMIN","admin");
            Role role1 = new Role("USER","user");


            roleRepository.save(role2);
            roleRepository.save(role1);
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserServiceImpl userService, RoleServiceImpl roleService) {
        return (args)->{
            Set<Role> roles = new HashSet<>();
            /*Role role2= new Role("ADMIN","admin");
            Role role1 = new Role("USER","user");


            roleService.save(role2);
            roleService.save(role1);*/
//            Role role = roleRepository.findByName("USER");
//            roles.add(role);

            User user = new User();



            user.setEmail("darthir@onet.eu");
            user.setUsername("root");
            user.setPassword("5kwrVhWh");
//            user.setRoles(roles);
            userService.create(user);
        };

    }

}
