package com.stackroute.MovieApp.controller;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.exceptions.MovieAlreadyExistsException;
import com.stackroute.MovieApp.exceptions.MovieNotFoundException;
import com.stackroute.MovieApp.repository.MovieRepository;
import com.stackroute.MovieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {

    @Autowired
   private MovieService movieService;

    MovieRepository movieRepository;
    ResponseEntity responseEntity;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {

        movieService.saveMovie(movie);
        responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable int id){
        try {
            movieService.deleteMovieById(id);
            responseEntity = new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("movie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable int id, @RequestBody Movie upMovie){

        try {
            movieService.updateMovie(id, upMovie);
            responseEntity = new ResponseEntity<String>("Successfully Updated",HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies(){

        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie/moviename={name}")
    public ResponseEntity<?> getMovieByName(@PathVariable String name) throws MovieNotFoundException {
        List<Movie> neededMovie = movieService.findByName(name);
        if(!neededMovie.isEmpty()) {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.findByName(name), HttpStatus.OK);
            return responseEntity;
        }else {
            responseEntity = new ResponseEntity<String>("No Movie Found By That Name", HttpStatus.CONFLICT);
            return responseEntity;
        }
    }





}
