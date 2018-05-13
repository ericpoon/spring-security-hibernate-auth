package com.demo.springsecurity.demo.services;

import com.demo.springsecurity.demo.dao.AuthorityDao;
import com.demo.springsecurity.demo.dao.UserDao;
import com.demo.springsecurity.demo.entity.Authority;
import com.demo.springsecurity.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HibernateUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByName(username);
        List<Authority> authorities = authorityDao.getUserAuthorities(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        System.out.println("\n>>> Authenticating");
        System.out.println(user);

//        for (Authority authority : authorities) {
//            grantedAuthorityList.add(new SimpleGrantedAuthority(authority.getAuthority()));
//        }

//        user.setAuthorities(grantedAuthorityList);

        return user;
    }
}
