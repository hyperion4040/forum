/**
 * Created by Adrian Kozłowski on 17.07.2018
 */
package edu.adrianKozlowski.forum.service;

import java.util.List;

import edu.adrianKozlowski.forum.entity.Section;


public interface SectionService {
    
    List<Section> findAll();
    
    Section findOne(int id);
    
    Section findByName(String name);
    
    Section save(Section section);
    
    void delete(int id);
    
    void delete(Section section);
    
}
