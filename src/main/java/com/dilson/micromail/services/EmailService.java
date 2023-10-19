package com.dilson.micromail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dilson.micromail.enums.Status;
import com.dilson.micromail.models.Email;
import com.dilson.micromail.repositories.EmailRepository;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Email sendMail(Email email) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(email.getEmailFrom());
            mail.setTo(email.getEmailTo());
            mail.setSubject(email.getEmailSubject());
            mail.setText(email.getEmailMessage());
            javaMailSender.send(mail);
            email.setEmailStatus(Status.SENT);
        } catch (MailException e) {
            email.setEmailStatus(Status.ERROR);
        }

        return emailRepository.save(email);

    }
}
