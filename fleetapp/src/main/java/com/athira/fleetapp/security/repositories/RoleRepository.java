package com.athira.fleetapp.security.repositories;

import com.athira.fleetapp.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(
            value = "SELECT * FROM Role where id NOT IN (SELECT role_id from user_role WHERE user_id = ?1)",
            nativeQuery = true
    )
    Set<Role> getUserNotRoles(Integer userId);
}
