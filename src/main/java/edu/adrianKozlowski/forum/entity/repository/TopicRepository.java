/**
 * Created by Dawid Stankiewicz on 18.07.2016
 */
package edu.adrianKozlowski.forum.entity.repository;

import edu.adrianKozlowski.forum.entity.Section;
import edu.adrianKozlowski.forum.entity.Topic;
import edu.adrianKozlowski.forum.entity.User;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TopicRepository extends JpaRepository<Topic, Integer> {
    
    Set<Topic> findBySection(Section section);
    
    Set<Topic> findByUser(User user);
    
    Set<Topic> findAllByOrderByCreationDateDesc();
    
    Set<Topic> findTop5ByOrderByCreationDateDesc();
    
    
}
