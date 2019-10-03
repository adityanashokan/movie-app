package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.UserAlreadyExistsException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie){
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }

    @Override
    public void deleteMovie(int id) {
         movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findByName(String name) {
       return movieRepository.findByName(name);
    }


}
