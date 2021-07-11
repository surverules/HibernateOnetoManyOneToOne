package com.ms.hibernate.dao;

import com.ms.hibernate.entity.Address;
import com.ms.hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UserDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<User> getAllUser(){
        //return entityManager.createNativeQuery("select * from user").getResultList();
        //return entityManager.createQuery("select e from User e").getResultList();
        return entityManager.createQuery("from User").getResultList();
    }

    @Transactional
    public User getUser(int id){
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    public User removeUser(int id){
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }

    @Transactional
    public void addUser(User user){
        entityManager.persist(user);
    }


}
