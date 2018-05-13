package com.demo.springsecurity.demo.services;

import com.demo.springsecurity.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HibernateUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByName(username);

        System.out.println("\n>>> Authenticating");
        System.out.println(user);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
