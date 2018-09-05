package com.bitex.shomoy.mail.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * @author Neel Sinha (mailneelhere@gmail.com)
 * Date: 9/5/2018
 */
@Service

public class EmailService {
        private JavaMailSender javaMailSender;

    @PostConstruct
        public void mail(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }

        public void sendMail(String toEmail, String subject, String message) {
            toEmail = "neel.bitex@gmail.com";
            subject = "test";
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(toEmail);
            mailMessage.setSubject(subject);
            mailMessage.setText(message);
            mailMessage.setFrom("neel.bitex@gmail.com");
            javaMailSender.send(mailMessage);
        }
}
