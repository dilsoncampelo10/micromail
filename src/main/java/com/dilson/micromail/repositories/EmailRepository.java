package com.dilson.micromail.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilson.micromail.models.Email;

public interface EmailRepository extends JpaRepository<Email, UUID>{
    
}
