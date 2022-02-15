package com.athira.fleetapp.services;

import com.athira.fleetapp.entities.User;
import com.athira.fleetapp.entities.UserPrincipal;
import com.athira.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User Not Found!");
        }
//        return user; //we can return user here, but in spring security we need to return principle, i.e., UserDetails
//        The principal is the currently logged/authenticated in user
        return new UserPrincipal(user);
    }
}
