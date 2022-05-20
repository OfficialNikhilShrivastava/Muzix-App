package com.niit.usermovieservice.repository;

import com.niit.usermovieservice.domain.FavouriteMovie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteMovieRepository extends MongoRepository<FavouriteMovie, String> {
    FavouriteMovie findByMovieId(String movieId);
//    FavouriteMovie findByEmailId(String email);
    boolean deleteByMovieIdAndEmail(String movieId,String email);
    FavouriteMovie findByEmail(String email);
}
