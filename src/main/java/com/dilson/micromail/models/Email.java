package com.dilson.micromail.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.dilson.micromail.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "emails")
@Data
public class Email {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String emailName;
    
    @Column(nullable = false)
    private String emailFrom;

    @Column(nullable = false)
    private String emailTo;

    @Column(nullable = false)
    private String emailSubject;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String emailMessage;

    @CreationTimestamp
    private LocalDateTime emailSendDate;

    private Status emailStatus;
}
