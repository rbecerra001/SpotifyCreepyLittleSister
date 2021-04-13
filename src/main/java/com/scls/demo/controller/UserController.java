package com.scls.demo.controller;

import com.scls.demo.model.User;
import com.scls.demo.model.request.LoginRequest;
import com.scls.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * A Rest Controller for the User model.
 */
@RestController
@RequestMapping(path = "/auth/users")
public class UserController {
    private UserService userService; // handles the business end of User Model (separation of concerns)

    @Autowired // dependency injection
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    /*
     * http://localhost:9092/auth/users/register
     *
     * Creates a new user
     * params: User userObject - information needed to register a user (username(required), emailAddress(required), password(required))
     * returns: User - the created user
     */
    @PostMapping(path = "/register")
    public User createUser(@RequestBody User userObject){
        System.out.println("Calling createUser()");
        return userService.createUser(userObject);
    }

    /*
     * http://localhost:9092/auth/users/login
     *
     * Logs a user in
     * params: LoginRequest loginRequest - information needed for a login request (email(required), password(required))
     * returns: ResponseEntity<?> - a response with the JWT if user was successfully logged in
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        System.out.println("Calling loginUser()");
        return userService.loginUser(loginRequest);
    }
}
