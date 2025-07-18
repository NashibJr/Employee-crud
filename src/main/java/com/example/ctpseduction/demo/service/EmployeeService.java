package com.example.ctpseduction.demo.service;

import com.example.ctpseduction.demo.entity.EmployeeEntity;
import com.example.ctpseduction.demo.repository.*;

import java.util.List;

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

    public List<EmployeeEntity> get() {
        List<EmployeeEntity> employees = employeeRepository.findAll();

        return employees;
    }

    public String delete(String id) {
        employeeRepository.deleteById(id);

        return "Employee successfully deleted";
    }

    public EmployeeEntity getOne(String id) {
        EmployeeEntity employee = 
            employeeRepository.findById(id).orElse(null);

        return employee;
    }

    public EmployeeEntity update(EmployeeEntity employeeData) {
        EmployeeEntity employee = employeeRepository.save(employeeData);

        return employee;
    }
}
