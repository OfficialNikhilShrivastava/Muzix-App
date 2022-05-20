package com.niit.controller;

import com.niit.domain.User;
import com.niit.exception.InvalidCredentialException;
import com.niit.exception.UserAlreadyExistsException;
import com.niit.security.SecurityTokenGenerator;
import com.niit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class UserController {
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialException
    {
        User retrievedUser = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(retrievedUser==null)
        {
            throw new InvalidCredentialException();
        }
        Map<String,String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
