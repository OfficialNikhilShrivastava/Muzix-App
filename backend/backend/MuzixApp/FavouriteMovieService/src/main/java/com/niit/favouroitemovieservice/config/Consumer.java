package com.niit.favouroitemovieservice.config;

import com.niit.favouroitemovieservice.domain.Favourite;
import com.niit.favouroitemovieservice.exception.MovieAlreadyExistsException;
import com.niit.favouroitemovieservice.service.FavouriteServiceImpl;
import com.niit.rabbitmq.domain.FavouriteDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private FavouriteServiceImpl favouriteService;

    @RabbitListener(queues="favourite_movie_queue")
    public void getFavouriteDtoFromRabbitMq(FavouriteDTO favouriteDTO) throws MovieAlreadyExistsException
    {
        Favourite favourite=new Favourite();
        favourite.setMovieId(favouriteDTO.getMovieId());
        favourite.setMovieName(favouriteDTO.getMovieName());
        favourite.setEmail(favouriteDTO.getEmail());
        favouriteService.saveFavourite(favourite);
    }
}
