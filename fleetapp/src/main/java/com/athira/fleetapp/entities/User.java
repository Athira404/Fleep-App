package com.athira.fleetapp.entities;

import javax.persistence.*;

import com.athira.fleetapp.security.entities.Role;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String firstname;
    private String lastname;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

/*  A user can have many roles, same user can be admin and super admin
    There can be many users in single role(ex: three admins)
    Many-to-many relation
    Achieved using creating new table by joining two tables

    Cascade --> When the relationship owner (superclass) is saved/ deleted,
    then the mapped entity associated with it should also be saved/ deleted automatically
*/

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "userRole",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")}
    )
    Set<Role> roles = new HashSet<>();


}
