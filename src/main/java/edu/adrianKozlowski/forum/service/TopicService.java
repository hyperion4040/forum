/**
 * Created by Dawid Stankiewicz on 17.07.2016
 */
package edu.adrianKozlowski.forum.service;

import edu.adrianKozlowski.forum.entity.Topic;
import edu.adrianKozlowski.forum.entity.User;
import java.util.List;
import java.util.Set;

import edu.adrianKozlowski.forum.entity.Section;


public interface TopicService {
    
    List<Topic> findAll();
    
    Topic findOne(int id);
    
    Set<Topic> findRecent();
    
    Set<Topic> findAllByOrderByCreationDateDesc();
    
    Set<Topic> findBySection(Section section);
    
    Set<Topic> findBySection(String sectionName);
    
    Topic save(Topic topic);
    
    Set<Topic> findBySection(int id);
    
    Set<Topic> findByUser(User user);
    
    void delete(int id);
    
    void delete(Topic topic);
    
}
