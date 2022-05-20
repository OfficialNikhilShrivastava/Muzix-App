package com.niit.usermovieservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Favourite")
public class FavouriteMovie {
    @Id
    private String movieId;
    private String movieName;
    private String email;

    public FavouriteMovie() {
    }

    public FavouriteMovie(String movieId, String movieName, String email) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.email = email;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "FavouriteMovie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
