/**
 * Created by Dawid Stankiewicz on 04.08.2016
 */
package edu.adrianKozlowski.forum.service.model.impl;

import edu.adrianKozlowski.forum.controller.model.UserProfile;
import edu.adrianKozlowski.forum.entity.User;
import edu.adrianKozlowski.forum.service.PostService;
import edu.adrianKozlowski.forum.service.TopicService;
import edu.adrianKozlowski.forum.service.model.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.adrianKozlowski.forum.service.UserService;


@Service
public class UserProfileServiceImpl implements UserProfileService {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private TopicService topicService;
    
    @Override
    public UserProfile findOne(int userId) {
        UserProfile userProfile = new UserProfile();
        User user = userService.findOne(userId);
        userProfile.setUser(user);
        userProfile.setPosts(postService.findByUser(user));
        userProfile.setTopics(topicService.findByUser(user));
        return userProfile;
    }
    
    @Override
    public UserProfile findOne(String username) {
        return findOne(userService.findByUsername(username).getId());
    }
    
}
