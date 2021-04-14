package com.scls.demo.model.Request;

// this class will allow the user to login with the user name and password
public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
