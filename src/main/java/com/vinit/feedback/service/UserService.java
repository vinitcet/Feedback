package com.vinit.feedback.service;

import com.vinit.feedback.dao.UserDao;
import com.vinit.feedback.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User createUser(User user) {
        return userDao.save(user);
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }
}
