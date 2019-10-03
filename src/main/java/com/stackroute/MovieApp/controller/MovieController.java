package com.stackroute.MovieApp.controller;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
import com.stackroute.MovieApp.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class MovieController {

    MovieService movieService;
    MovieRepository movieRepository;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id){
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovie(id);
            responseEntity = new ResponseEntity<String>("Successfully Deleted",HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("movie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable int id, @RequestBody Movie upMovie){
        ResponseEntity responseEntity;
        try {
            movieService.deleteMovie(id);
            movieService.saveMovie(upMovie);
            responseEntity = new ResponseEntity<String>("Successfully Updated",HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies(){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie/moviename={name}")
    public ResponseEntity<?> getMovieByName(@PathVariable String name){
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Movie>>(movieService.findByName(name), HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }



}
