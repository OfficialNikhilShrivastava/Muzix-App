package com.niit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Invalid Credentials")
public class UserAlreadyExistsException extends Exception {
}
