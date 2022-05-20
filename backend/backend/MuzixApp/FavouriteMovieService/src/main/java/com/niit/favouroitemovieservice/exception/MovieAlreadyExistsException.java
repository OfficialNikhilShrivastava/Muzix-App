package com.niit.favouroitemovieservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "this movie already exists")
public class MovieAlreadyExistsException extends Exception{
}
