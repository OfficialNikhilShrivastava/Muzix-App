package com.niit.usermovieservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "this user already exist")
public class UserAlreadyExistsException extends Throwable {
}
