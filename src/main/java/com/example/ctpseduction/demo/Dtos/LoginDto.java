package com.example.ctpseduction.demo.Dtos;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getemail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}
