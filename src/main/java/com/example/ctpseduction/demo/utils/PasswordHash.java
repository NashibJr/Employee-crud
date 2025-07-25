package com.example.ctpseduction.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.ctpseduction.demo.entity.UserEntity;

public class PasswordHash {
    private BCryptPasswordEncoder handlePassword = new BCryptPasswordEncoder();

    public String hashPassword(String password) {
        return handlePassword.encode(password);
    }

    public boolean checkPassword(String password, UserEntity user) {
        return handlePassword.matches(password, user.getPassword());
    }
}
