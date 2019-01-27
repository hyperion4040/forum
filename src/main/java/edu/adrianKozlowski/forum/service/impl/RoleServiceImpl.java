/**
 * Created by Dawid Stankiewicz on 22.07.2016
 */
package edu.adrianKozlowski.forum.service.impl;

import edu.adrianKozlowski.forum.entity.Role;
import edu.adrianKozlowski.forum.entity.repository.RoleRepository;
import edu.adrianKozlowski.forum.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public Role findOne(int id) {
        return roleRepository.findOne(id);
    }
    
    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
    
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    
    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
    
    @Override
    public void save(String name,
                     String description) {
        save(new Role(name, description));
    }
    
    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }
    
    @Override
    public void delete(String name) {
        delete(findByName(name));
    }
    
    @Override
    public void delete(int id) {
        delete(findOne(id));
    }
    
}
