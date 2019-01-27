/**
 * Created by Adrian Kozłowski on 18.07.2018
 */
package edu.adrianKozlowski.forum.service.impl;

import edu.adrianKozlowski.forum.service.SectionService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.adrianKozlowski.forum.entity.Section;
import edu.adrianKozlowski.forum.entity.repository.SectionRepository;


@Service
public class SectionServiceImpl implements SectionService {
    
    @Autowired
    private SectionRepository sectionRepository;
    
    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }
    
    @Override
    public Section findOne(int id) {
        return sectionRepository.findOne(id);
    }
    
    @Override
    public Section findByName(String name) {
        return sectionRepository.findByName(name);
    }
    
    @Override
    public Section save(Section section) {
        return sectionRepository.save(section);
    }
    
    @Override
    public void delete(int id) {
        delete(findOne(id));
    }
    
    @Override
    public void delete(Section section) {
        sectionRepository.delete(section);
    }
    
}
