package com.stackroute.MovieApp.service;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exceptions.MovieNotFoundException;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"service1","default"})
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        if(movieRepository.existsById(movie.getMovieId())){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if(savedMovie == null){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        return savedMovie;
    }

    @Override
    public Movie deleteMovieById(int id) throws MovieNotFoundException {
        if(movieRepository.existsById(id)) {
            Movie deletedMovie = movieRepository.findById(id).get();
            movieRepository.deleteById(id);
            return deletedMovie;
        }else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }

    @Override
    public List<Movie> getAllMovies() throws MovieNotFoundException {
        if(!movieRepository.findAll().isEmpty())
            return movieRepository.findAll();
        else
            throw new MovieNotFoundException("No Movies Found");
    }

    @Override
    public List<Movie> findByName(String name) throws MovieNotFoundException {
        if(movieRepository.findByName(name).isEmpty()){
            throw new MovieNotFoundException("Movie Not Found");
        }
        return movieRepository.findByName(name);
    }

    @Override
    public Movie updateMovie(int id, Movie movie) throws MovieNotFoundException {
        if(!movieRepository.existsById(id)){
            movieRepository.deleteById(id);
            movieRepository.save(movie);
            return movie;
        }else {
            throw new MovieNotFoundException("Movie Not Found");
        }
    }


}
