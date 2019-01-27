/**
 * Created by Adrian Kozłowski on 22.07.2018
 */
package edu.adrianKozlowski.forum.entity.repository;

import edu.adrianKozlowski.forum.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Role findByName(String name);
    
}
