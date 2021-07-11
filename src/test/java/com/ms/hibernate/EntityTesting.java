package com.ms.hibernate;

import com.ms.hibernate.dao.AddressDao;
import com.ms.hibernate.dao.TelephoneDao;
import com.ms.hibernate.dao.UserDao;
import com.ms.hibernate.entity.Address;
import com.ms.hibernate.entity.Telephone;
import com.ms.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EntityTesting {

    @Autowired
    AddressDao addressDao;

    @Autowired
    UserDao userDao;

    @Autowired
    TelephoneDao telephoneDao;

    @Autowired
    EntityManager entityManager;

    @Test
    public void getAllUser(){
        List<User> allUser = userDao.getAllUser();
        for(User user: allUser){
            System.out.println("User : " + user);
        }
        Assert.assertTrue(allUser.size() > 0);
    }

    @Test
    public void getUser(){
        User user = userDao.getUser(10001);
        System.out.println("User : " + user.toString());
    }

    @Test
    //!!! Note we are saving ourself hte Address and then Pointing its relation to User
    public void insertUserAndAddress(){
        Address address = new Address();
        address.setCityName("pune");
        address.setCountryName("india");
        addressDao.addAddress(address);

        User user = new User();
        user.setAddress(address);
        user.setFirstName("Mahesh");
        user.setLastName("More");
        userDao.addUser(user);

    }

    @Test
    /**
     *  There the CasCade Type of Cascade.ALL Plays a Magic and
     *  saves data into Parent and Child
     */
    public void OnlypersistUserandAddressWillSaveByCasCade(){
        Address address = new Address();
        address.setCityName("Dhule");
        address.setCountryName("india");
        User user = new User();
        user.setAddress(address);
        user.setFirstName("Rahul");
        user.setLastName("More");
        userDao.addUser(user);

    }

    @Test
    /**
     *  There the CasCade Type of Cascade.ALL Plays a Magic and
     *  saves data into Parent and Child
     */
    public void OnlypersistUserandAddressWillSaveByCasCadeAmol(){
        Address address = new Address();
        address.setCityName("Shirun");
        address.setCountryName("india");
        User user = new User();
        user.setAddress(address);
        user.setFirstName("Amol");
        user.setLastName("Karnawat");
        userDao.addUser(user);

    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setFirstName("Mahesh");
        user.setLastName("More");
        userDao.addUser(user);
    }


    @Test
    public void insertUserWithAddressAndTelephones(){
        Address address = new Address();
        address.setCityName("Pune");
        address.setCountryName("india");

        User user = new User();
        user.setAddress(address);
        user.setFirstName("Amarnath");
        user.setLastName("DeshPande");


        Telephone telephone = new Telephone();
        telephone.setTelephoneNumber(12345);
        user.getTelephoneList().add(telephone);

        Telephone telephone1 = new Telephone();
        telephone1.setTelephoneNumber(98876);
        user.getTelephoneList().add(telephone1);

        telephone.setUser(user);
        telephone1.setUser(user);

        userDao.addUser(user);


    }
}
