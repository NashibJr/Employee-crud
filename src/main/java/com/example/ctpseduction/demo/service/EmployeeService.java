package com.example.ctpseduction.demo.service;

import com.example.ctpseduction.demo.entity.EmployeeEntity;
import com.example.ctpseduction.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeEntity create(EmployeeEntity employeeData) {
        EmployeeEntity employee = employeeRepository.save(employeeData);

        return employee;
    }
}
