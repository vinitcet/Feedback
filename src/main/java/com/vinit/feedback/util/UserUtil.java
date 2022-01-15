package com.vinit.feedback.util;

import com.vinit.feedback.entity.User;
import com.vinit.feedback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUtil {

    @Autowired
    private UserService userService;

    public User getUserName(Long id) {
        return userService.getAllUsers().stream().filter(user -> user.getId() == id).findFirst().get();

    }
}
