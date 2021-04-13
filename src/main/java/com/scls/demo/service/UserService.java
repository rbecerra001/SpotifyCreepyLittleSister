package com.scls.demo.service;

import com.scls.demo.exception.InformationExistException;
import com.scls.demo.model.User;
import com.scls.demo.model.request.LoginRequest;
import com.scls.demo.model.response.LoginResponse;
import com.scls.demo.repository.UserRepository;
import com.scls.demo.security.JWTUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 * UserService implements the business logic for UserController.
 */
@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired // dependency injection
    private AuthenticationManager authenticationManager;
    @Autowired // dependency injection
    private UserDetailsService userDetailsService;
    @Autowired // dependency injection
    private JWTUtils jwtUtils;
    @Autowired // dependency injection
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Autowired // dependency injection
    public void setPasswordEncoder(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    /*
     * Creates a new user
     * params: User userObject - information needed to register a user (username(required), emailAddress(required), password(required))
     * returns: User - the created user. Throws an exception if the user already exists.
     */
    public User createUser(User userObject){
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())){
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        }else{
            throw new InformationExistException("The user with " + userObject.getEmailAddress()+  " already exists.");
        }
    }

    /*
     * Logs a user in
     * params: LoginRequest loginRequest - information needed for a login request (email(required), password(required))
     * returns: ResponseEntity<?> - a response with the JWT if user was successfully logged in
     */
    public ResponseEntity<?> loginUser(LoginRequest loginRequest) {
        authenticationManager.authenticate(new
                UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
        final String JWT = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new LoginResponse(JWT));
    }

    /*
     * Gets a user with their email address.
     * Param: String email - the user's emailAddress
     * Return: User - a user with the given email address
     */
    public User findUserByEmailAddress(String email) {
        return userRepository.findByEmailAddress(email);
    }

}
