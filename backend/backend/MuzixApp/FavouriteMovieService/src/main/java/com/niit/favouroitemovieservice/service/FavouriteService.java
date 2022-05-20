package com.niit.favouroitemovieservice.service;

import com.niit.favouroitemovieservice.domain.Favourite;
import com.niit.favouroitemovieservice.exception.MovieAlreadyExistsException;
import com.niit.favouroitemovieservice.exception.MovieNotFoundException;

import java.util.List;

public interface FavouriteService {
    Favourite saveFavourite(Favourite favourite) throws MovieAlreadyExistsException;
    Favourite findByMovieId(String movieId);
    List<Favourite> findMoviesByEmail(String email);
    boolean deleteMovieFromFavourites(String movieId,String email) throws MovieNotFoundException;

}
