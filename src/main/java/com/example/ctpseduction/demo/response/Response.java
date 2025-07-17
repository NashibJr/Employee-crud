package com.example.ctpseduction.demo.response;

import com.example.ctpseduction.demo.entity.EmployeeEntity;

public class Response {
    private EmployeeEntity employee;
    private String message;

    public Response(EmployeeEntity employee, String message) {
        this.employee = employee;
        this.message = message;
    }

    // set and get employee
    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    public EmployeeEntity getEmploy() {
        return this.employee;
    }

    // set and get message
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}