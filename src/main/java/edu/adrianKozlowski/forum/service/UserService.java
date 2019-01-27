/**
 * Created by Adrian Kozłowski on 11.07.2018
 */
package edu.adrianKozlowski.forum.service;

import edu.adrianKozlowski.forum.entity.User;
import java.util.List;


public interface UserService {

    List<User> findAll();

    User findOne(int id);

    User findByUsername(String username);

    User findByEmail(String email);

    User save(User user);

    void create(User user);

    void remove(int id);

    void remove(User user);

    void remove(User user,
        String password);
}
