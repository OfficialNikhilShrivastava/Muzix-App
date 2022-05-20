package com.niit.usermovieservice.repository;

import com.niit.usermovieservice.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMovieRepository extends MongoRepository<User,String> {
}
