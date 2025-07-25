package com.example.ctpseduction.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.ctpseduction.demo.entity.UserEntity;

public interface UserRespository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
}
