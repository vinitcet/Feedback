package com.vinit.feedback.controller;

import com.vinit.feedback.entity.User;
import com.vinit.feedback.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping(value = "/allUsers")
    public List<String> getAllUsersName() {
        return userService.getAllUsers().stream().map(User::getFirstName).collect(Collectors.toList());
    }

    @GetMapping(value = "/addUser")
    public void addUser() {
        User user = new User();
        user.setId(5l);
        user.setActive(true);
        user.setFirstName("Vihaan");
        user.setLastName("Verma");
        user.setPassword("Password");
        user.setPasswordChangeRequired(false);
        user.setCreatedBy("Admin");
        user.setEmail("vihaanverma@gmail.com");
        user.setCreatedDate(LocalDateTime.now());
        user.setModifiedDate(LocalDateTime.now());
        user.setDepartment("Engineering");
        user.setLocation("India");
        user.setGender("Male");
        user.setModifiedBy("Admin");
        user.setPosition("Trainee");
        user.setPhone("9620052202");
        user.setReportsTo(2l);
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

    @GetMapping(value = "/addPhoto")
    void addPhoto(@RequestParam Long id, @RequestParam String photo) throws IOException {
        User user = userService.getUser(id).get();
        FileInputStream fis = new FileInputStream(new File(photo));
        user.setImageContent(fis.readAllBytes());
        userService.saveUser(user);
    }
}