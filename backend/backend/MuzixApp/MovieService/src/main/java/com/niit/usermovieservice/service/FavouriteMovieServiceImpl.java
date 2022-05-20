package com.niit.usermovieservice.service;

import com.niit.rabbitmq.domain.FavouriteDTO;
import com.niit.usermovieservice.config.Producer;
import com.niit.usermovieservice.domain.FavouriteMovie;
import com.niit.usermovieservice.exception.MovieAlreadyExistsException;
import com.niit.usermovieservice.exception.MovieNotFoundException;
import com.niit.usermovieservice.repository.FavouriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteMovieServiceImpl implements FavouriteMovieService{

    private FavouriteMovieRepository favouriteMovieRepository;
    private Optional<FavouriteMovie> favMovie;
    @Autowired
    Producer producer;
    @Autowired
    public FavouriteMovieServiceImpl(FavouriteMovieRepository favouriteMovieRepository) {
        this.favouriteMovieRepository = favouriteMovieRepository;
    }

    @Override
    public FavouriteMovie registerFavourite(FavouriteMovie favouriteMovie) throws MovieAlreadyExistsException {
        FavouriteDTO favouriteDTO=new FavouriteDTO();
        favouriteDTO.setMovieId(favouriteMovie.getMovieId());
        favouriteDTO.setMovieName(favouriteMovie.getMovieName());
        favouriteDTO.setEmail(favouriteMovie.getEmail());
        if(favouriteMovieRepository.findById(favouriteMovie.getMovieId()).isPresent() )
        {
            favMovie=getFavouriteMovieByMovieId(favouriteMovie.getMovieId());
            if(favouriteMovie.getEmail().equals(favMovie.get().getEmail()))
            {
                throw new MovieAlreadyExistsException();
            }
            else
            {
                favouriteMovieRepository.save(favouriteMovie);
                System.out.println("saved user in mongo");
                producer.sendMessageToRabbitMq(favouriteDTO);
            }

        }
        else{
            favouriteMovieRepository.save(favouriteMovie);
            System.out.println("saved user in mongo");
            producer.sendMessageToRabbitMq(favouriteDTO);
        }
        return favouriteMovie;
    }

    @Override
    public boolean deleteMovieFromFavourites(String movieId, String email) throws MovieNotFoundException {
        favouriteMovieRepository.deleteByMovieIdAndEmail(movieId,email);
        return true;
    }

    public Optional<FavouriteMovie> getFavouriteMovieByMovieId(String movieId){
        return favouriteMovieRepository.findById(movieId);
    }
}
