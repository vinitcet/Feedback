package com.vinit.feedback.service;

import com.vinit.feedback.dao.UserDao;
import com.vinit.feedback.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Cacheable(value = "users")
    public List<User> getAllUsers() {
        List<User> userList = userDao.findAll();
        userList.stream().forEach(user -> user.setImageContent(null));
        return userList;
    }

    @CacheEvict(value = "users", allEntries = true)
    public User createUser(User user) {
        return userDao.save(user);
    }

    public User saveUser(User user) {
        return userDao.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    public Optional<User> getUser(Long id) {
        return userDao.findById(id);
    }

    public Optional<User> findUserByFirstName(String name) {
        return userDao.findUserByFirstName(name);
    }

    public Optional<User> findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}

