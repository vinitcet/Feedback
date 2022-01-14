package com.vinit.feedback.service;

import com.vinit.feedback.entity.Assessment;
import com.vinit.feedback.entity.User;
import com.vinit.feedback.mail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    public EmailService emailService;
    private static final String NOREPLY_ADDRESS = "noreply@feedbackapp.com";

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private UserService userService;

    public void sendSimpleMessage(Assessment assessment, User user) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            User accessor = userService.getUser(assessment.getAccessorId()).get();
            message.setTo(accessor.getEmail());
            message.setSubject("New Feedback request::" + user.getFullName());
            message.setText(
                    "A feedback request has been raised by " + user.getFullName()
                            + "\n" + "Message : " +
                            assessment.getFeedbackMessage()
                            + "\n\n\n" + "This is a system generated mail. Copyright Feedback 360 App"

            );
            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
