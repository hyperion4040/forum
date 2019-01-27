/**
 * Created by Dawid Stankiewicz on 3 Jul 2016
 */
package edu.adrianKozlowski.forum.entity.repository;

import edu.adrianKozlowski.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);
    
    User findByEmail(String email);
    
}
