package com.example.ctpseduction.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ctpseduction.demo.entity.UserEntity;

@Repository
public interface UserRespository extends MongoRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
}
