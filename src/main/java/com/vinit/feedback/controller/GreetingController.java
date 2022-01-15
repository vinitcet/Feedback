package com.vinit.feedback.controller;

import com.vinit.feedback.dao.UserDao;
import com.vinit.feedback.entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
@Log
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    UserDao userRepository;

    @RequestMapping("/greeting")
    public User greeting(@RequestParam(value = "name", defaultValue = "User") String name, @RequestHeader Map<String, String> headers,
                         Authentication authentication, Principal principal) {
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });
        System.out.println(authentication.getName());
        System.out.println("-----------------");
        System.out.println(principal.getName());
        name = (null != authentication.getName()) ? authentication.getName() : "User";

        Optional<User> user = userRepository.findUserByFirstName(name);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: "));

        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
        return user.get();

    }
}
