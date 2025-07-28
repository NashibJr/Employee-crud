package com.example.ctpseduction.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @JsonProperty("_id")
    private String id;

    @Field("User name")
    @NotBlank(message = "This field is required")
    private String username;

    @NotBlank(message = "This field is required")
    @Email(message = "Enter a vlaid email address")
    @Indexed(unique = true)
    private String email;

    @NotBlank(message = "This field is required")
    private String password;
}
