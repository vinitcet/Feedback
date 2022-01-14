package com.vinit.feedback.controller;

import com.vinit.feedback.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    public EmailService emailService;
    private static final String NOREPLY_ADDRESS = "noreply@feedbackapp.com";

    @Autowired
    private JavaMailSender emailSender;

    @RequestMapping(value = {"/send", "/sendTemplate", "/sendAttachment"}, method = RequestMethod.GET)
    public void sendSimpleMessage() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo("vinitlucknow29@gmail.com");
            message.setSubject("subject");
            message.setText("text");

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

}
