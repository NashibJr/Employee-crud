package com.example.ctpseduction.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ctpseduction.demo.entity.UserEntity;
import com.example.ctpseduction.demo.repository.UserRespository;
import com.example.ctpseduction.demo.response.Response;
import com.example.ctpseduction.demo.utils.PasswordHash;

@Service
public class UserService {
    @Autowired
    UserRespository userRespository;

    // create a user
    public Response create(UserEntity userDto) {
        UserEntity userExists = userRespository.findByEmail(userDto.getEmail());
        if (userExists != null) {
            return new Response("User with this email already exists");
        }

        PasswordHash hash = new PasswordHash();
        userDto.setPassword(hash.hashPassword(userDto.getPassword()));
        userRespository.save(userDto);

        return new Response(userDto, "User succefully created");
    }

    // get users
    public List<UserEntity> getUsers() {
        return userRespository.findAll();
    }
}
