package com.niit.service;

import com.niit.domain.User;
import com.niit.exception.InvalidCredentialException;
import com.niit.exception.UserAlreadyExistsException;
import org.apache.http.auth.InvalidCredentialsException;

public interface UserService {
    User saveUser(User user) throws UserAlreadyExistsException;
    User findByEmailAndPassword(String email, String password) throws InvalidCredentialException;
}
