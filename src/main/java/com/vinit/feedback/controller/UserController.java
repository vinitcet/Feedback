package com.vinit.feedback.controller;

import com.vinit.feedback.entity.User;
import com.vinit.feedback.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/user-management", produces = {MediaType.APPLICATION_JSON_VALUE})
@Log
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/addUser")
    public void addUser() {
        User user = new User();
        user.setId(4l);
        user.setActive(true);
        user.setFirstName("Pushpa");
        user.setLastName("Verma");
        user.setPassword("Password");
        user.setPasswordChangeRequired(false);
        user.setCreatedBy("Admin");
        user.setEmail("pushpa91@gmail.com");
        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        user.setDepartment("Hardware");
        user.setLocation("India");
        user.setGender("Female");
        user.setModifiedBy("Admin");
        user.setPosition("Manager");
        user.setPhone("9415688221");
        user.setReportsTo(1l);
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @PostMapping("/user")
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @DeleteMapping("/user/{id}")
    void deleteEmployee(@PathVariable Long id) {
        userService.deleteUser(id);
    }


}
