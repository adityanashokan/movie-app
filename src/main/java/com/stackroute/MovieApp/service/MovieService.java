package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.UserAlreadyExistsException;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MovieService {
    public Movie saveMovie(Movie movie) throws UserAlreadyExistsException;

    public void deleteMovie(int id);

    public List<Movie> getAllMovies();

    public List<Movie> findByName(String name);
}
