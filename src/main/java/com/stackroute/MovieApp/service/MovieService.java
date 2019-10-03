package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exceptions.MovieNotFoundException;

import java.util.List;


public interface MovieService {
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    public void deleteMovie(int id);

    public List<Movie> getAllMovies();

    public List<Movie> findByName(String name) throws MovieNotFoundException;
}
