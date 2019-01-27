/**
 * Created by Dawid Stankiewicz on 02.08.2016
 */
package edu.adrianKozlowski.forum.service;

import static org.junit.Assert.assertEquals;

import edu.adrianKozlowski.forum.ConfigTest;
import edu.adrianKozlowski.forum.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceTest extends ConfigTest {
    
    @Autowired
    UserService userService;
    
    @Test
    @Transactional
    public void testAddNewUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("user");
        user.setEmail("test@ema.il");
        userService.create(user);

    }
}
