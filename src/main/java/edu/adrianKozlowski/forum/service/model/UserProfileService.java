/**
 * Created by Adrian Kozłowski on 04.08.2018
 */
package edu.adrianKozlowski.forum.service.model;

import edu.adrianKozlowski.forum.controller.model.UserProfile;


public interface UserProfileService {
    
    public UserProfile findOne(int userId);
    
    public UserProfile findOne(String username);
    
}
