/**
 * Created by Adrian Kozłowski on 11.07.2018
 */
package edu.adrianKozlowski.forum.service.impl;

import edu.adrianKozlowski.forum.entity.Role;
import edu.adrianKozlowski.forum.entity.User;
import edu.adrianKozlowski.forum.entity.UserInfo;
import edu.adrianKozlowski.forum.entity.repository.UserRepository;
import edu.adrianKozlowski.forum.exception.IncorrectPasswordException;
import edu.adrianKozlowski.forum.exception.UserNotFoundException;
import edu.adrianKozlowski.forum.service.RoleService;
import edu.adrianKozlowski.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
//            return new User();
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void create(User user) {
        Set<Role> roles = new HashSet<>();
        Role role = roleService.findByName("USER");
//        Role role = new Role("USER","user");
        roles.add(role);
        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        UserInfo info = new UserInfo();
        info.setUser(user);
        user.setInfo(info);
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        remove(findOne(id));
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public void remove(User user,
        String password) {
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("user: " + user.getPassword() + " pass: " + passwordEncoder.encode(
                password));
            throw new IncorrectPasswordException();
        }
        userRepository.delete(user);
    }
}
