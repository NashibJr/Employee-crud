package com.example.ctpseduction.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.ctpseduction.demo.entity.EmployeeEntity;
import com.example.ctpseduction.demo.response.Response;
import com.example.ctpseduction.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    Response createEmployee(@Valid @RequestBody EmployeeEntity employeeData) {
        EmployeeEntity employee = service.create(employeeData);
        Response response = new Response(
            employee, 
            "Employee successfully created"
        );

        return response;
    }    

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    List<EmployeeEntity> get() {
        return service.get();
    }
}
