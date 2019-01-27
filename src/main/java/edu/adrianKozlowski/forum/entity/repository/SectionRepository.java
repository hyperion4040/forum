/**
 * Created by Adrian Kozłowski on 17.07.2018
 */
package edu.adrianKozlowski.forum.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.adrianKozlowski.forum.entity.Section;


public interface SectionRepository extends JpaRepository<Section, Integer> {
    
    Section findByName(String name);
    
}
