package com.ms.hibernate.dao;

import com.ms.hibernate.entity.Telephone;
import com.ms.hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class TelephoneDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Telephone> getAllTelephone(){
        //return entityManager.createNativeQuery("select * from user").getResultList();
        //return entityManager.createQuery("select e from User e").getResultList();
        return entityManager.createQuery("from User").getResultList();
    }

    @Transactional
    public Telephone getTelephone(int id){
        Telephone telephone = entityManager.find(Telephone.class, id);
        return telephone;
    }

    @Transactional
    public Telephone removeTelephone(int id){
        Telephone telephone = entityManager.find(Telephone.class, id);
        entityManager.remove(telephone);
        return telephone;
    }

    @Transactional
    public void addTelephone(Telephone telephone){
        entityManager.persist(telephone);
    }


}
