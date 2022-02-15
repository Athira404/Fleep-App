package com.athira.fleetapp.security.services;

import com.athira.fleetapp.entities.User;
import com.athira.fleetapp.repositories.UserRepository;
import com.athira.fleetapp.security.entities.Role;
import com.athira.fleetapp.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public void save(Role role) {
        roleRepository.save(role);
    }

    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    public void assignUserRole(Integer userId, Integer roleId) {
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public void unassignUserRole(Integer userId, Integer roleId) {
        User user = userRepository.findById(userId).orElse(null);
        Set<Role> userRoles = user.getRoles();

        userRoles.removeIf(x -> x.getId() == roleId);
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user) {
        return user.getRoles();
    }

//        Set of roles that user doesn't have
//        I need to get two entities, both roles and users, and then I've to get roles the user doesn't have, get it from the role table,
//        To achieve, I've to write sql query, awsm
    public Set<Role> getUserNotRoles(User user) {
        return roleRepository.getUserNotRoles(user.getId());
    }
}
