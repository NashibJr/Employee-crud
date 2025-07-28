package com.example.ctpseduction.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.ctpseduction.demo.Dtos.LoginDto;
import com.example.ctpseduction.demo.entity.UserEntity;
import com.example.ctpseduction.demo.repository.UserRespository;
import com.example.ctpseduction.demo.response.Response;
import com.example.ctpseduction.demo.utils.Jwtutil;
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

    // get user by id
    public UserEntity getUser(String id) {
        UserEntity user = userRespository.findById(id).orElse(null);
        user.setPassword(null);

        return user;
    }

    public Response login(LoginDto loginData) {
        PasswordHash checkPassword = new PasswordHash();
        UserEntity exists = userRespository.findByEmail(loginData.getemail());
        if (exists == null) {
            return new Response("User not found");
        }
        // check the password
        boolean isPasswordCorrect = checkPassword
                .checkPassword(loginData.getPassword(), exists);
        if (!isPasswordCorrect) {
            return new Response("You're password is incorrect.");
        }
        String token = Jwtutil.getToken(exists.getId());

        return new Response(exists, token);
    }

    public UserDetails userDetails(String id) {
        UserEntity user = userRespository.findById(id).orElse(null);

        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
