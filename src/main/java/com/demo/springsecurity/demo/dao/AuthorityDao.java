package com.demo.springsecurity.demo.dao;

import com.demo.springsecurity.demo.entity.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<Authority> getUserAuthorities(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query<Authority> query = session.createQuery("from Authority a where a.key.user.username=:username", Authority.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

}
