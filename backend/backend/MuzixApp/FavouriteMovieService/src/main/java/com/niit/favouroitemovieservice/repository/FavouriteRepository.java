package com.niit.favouroitemovieservice.repository;

import com.niit.favouroitemovieservice.domain.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite, String> {
    Favourite findByMovieId(String movieId);
    List<Favourite> findAllMoviesByEmail(String email);
    boolean deleteByMovieIdAndEmail(String movieId,String email);
}
