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
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Transactional
    public User getUserByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.username=:name", User.class);
        query.setParameter("name", name);
        Object result = query.uniqueResult();
        if (result != null) {
            return (User) result;
        } else {
            return null;
        }
    }

    @Transactional
    public void createUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}
