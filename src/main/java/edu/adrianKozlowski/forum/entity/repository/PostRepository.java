/**
 * Created by Dawid Stankiewicz on 18.07.2016
 */
package edu.adrianKozlowski.forum.entity.repository;

import edu.adrianKozlowski.forum.entity.Topic;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.adrianKozlowski.forum.entity.Post;
import edu.adrianKozlowski.forum.entity.User;


public interface PostRepository extends JpaRepository<Post, Integer> {
    
    Set<Post> findByUser(User user);
    
    Set<Post> findByTopic(Topic topic);
    
    Set<Post> findAllByOrderByCreationDateDesc();
    
    Set<Post> findTop5ByOrderByCreationDateDesc();
}
