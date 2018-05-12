package com.demo.springsecurity.demo.dao;

import com.demo.springsecurity.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<User> getUsers() {
        System.out.println(sessionFactory);
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User", User.class);
        return query.getResultList();
//        return null;
    }
}
