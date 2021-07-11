package com.ms.hibernate.dao;

import com.ms.hibernate.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddressDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Address> getAllAddress(){
        return entityManager.createQuery("select * from Address").getResultList();
    }

    @Transactional
    public Address getAddress(int id){
        return entityManager.find(Address.class, id);
    }

    @Transactional
    public Address removeAddress(int id){
        Address address = entityManager.find(Address.class, id);
        entityManager.remove(address);
        return address;
    }

    @Transactional
    public void addAddress(Address address){
        entityManager.persist(address);
    }
}
