package com.scls.demo.model.response;

// this class send back the JWT token if the user name and password is correct
public class LoginResponse {
    private String JWT;

    public LoginResponse(String JWT) {
        this.JWT = JWT;
    }

    public String getJWT() {
        return JWT;
    }

    public void setJWT(String JWT) {
        this.JWT = JWT;
    }
}
