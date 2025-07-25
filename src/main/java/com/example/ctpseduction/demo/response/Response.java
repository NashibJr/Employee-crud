package com.example.ctpseduction.demo.response;

public class Response {
    private Object object;
    private String message;

    public Response(Object object, String message) {
        this.object = object;
        this.message = message;
    }

    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }

    // set and get employee
    public void setObject(Object object) {
        this.object = object;
    }

    public Object getEmploy() {
        return this.object;
    }

    // set and get message
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}