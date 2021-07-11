package com.ms.hibernate.controller;

import com.ms.hibernate.dao.UserDao;
import com.ms.hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class Controller {

    @Autowired
    UserDao userDao;


    @GetMapping("/allusers")
    public List<User> getAllUsers(){
        return userDao.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        return userDao.getUser(id);
    }

}
