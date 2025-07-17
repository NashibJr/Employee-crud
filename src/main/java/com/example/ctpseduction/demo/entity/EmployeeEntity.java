package com.example.ctpseduction.demo.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.*;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    @Field("Full name")
    private String name;

    @Email(message = "Enter a valid email address")
    @Indexed(unique = true)
    private String email;

    @Size(min = 10, message = "Enter a valid phone number")
    private String phone;

    private String address;
}