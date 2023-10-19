package com.dilson.micromail.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDto {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String from;

    @NotBlank
    @Email
    private String to;

    @NotBlank
    private String subject;

    @NotBlank
    private String message;
}
