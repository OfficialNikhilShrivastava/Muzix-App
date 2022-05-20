package com.niit.usermovieservice.service;

import com.niit.usermovieservice.domain.User;
//import com.niit.MovieService.exception.UserAlreadyExistsException;
//import com.niit.MovieService.proxy.UserProxy;
//import com.niit.MovieService.repository.UserMovieRepository;
import com.niit.usermovieservice.exception.UserAlreadyExistsException;
import com.niit.usermovieservice.exception.UserNotFoundException;
import com.niit.usermovieservice.proxy.UserProxy;
import com.niit.usermovieservice.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMovieServiceImpl implements UserMovieService{
    private UserMovieRepository userMovieRepository;
    private UserProxy userProxy;

    @Autowired
    public UserMovieServiceImpl(UserMovieRepository userMovieRepository, UserProxy userProxy) {
        this.userMovieRepository = userMovieRepository;
        this.userProxy = userProxy;
    }

    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        if(userMovieRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        ResponseEntity responseEntity=userProxy.saveUser(user);
        System.out.println(responseEntity.getBody());
        return userMovieRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email) throws UserNotFoundException {
        if(userMovieRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userMovieRepository.findById(email);
    }


}
