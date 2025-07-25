package com.example.ctpseduction.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.ctpseduction.demo.entity.UserEntity;
import com.example.ctpseduction.demo.response.Response;
import com.example.ctpseduction.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    Response createUser(@Valid @RequestBody UserEntity userDto) {
        return userService.create(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    List<UserEntity> get() {
        return userService.getUsers();
    }
}
