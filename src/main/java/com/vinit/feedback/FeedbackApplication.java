package com.vinit.feedback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class FeedbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackApplication.class, args);
    }

}
