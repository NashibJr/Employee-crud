package com.example.ctpseduction.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ctpseduction.demo.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {}