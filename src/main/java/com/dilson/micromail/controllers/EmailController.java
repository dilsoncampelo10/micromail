package com.dilson.micromail.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilson.micromail.dtos.EmailDto;
import com.dilson.micromail.models.Email;
import com.dilson.micromail.services.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("emails")
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping
    public ResponseEntity<List<Email>> findAll() {
        var emails = this.emailService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(emails);
    }

    @PostMapping("/send")
    public ResponseEntity<Email> send(@RequestBody @Valid EmailDto emailDto) {
        var email = new Email();

        BeanUtils.copyProperties(emailDto, email);

        emailService.sendMail(email);

        return ResponseEntity.status(HttpStatus.CREATED).body(email);
    }
}
