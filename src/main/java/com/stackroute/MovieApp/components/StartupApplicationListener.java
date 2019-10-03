package com.stackroute.MovieApp.components;

import com.stackroute.MovieApp.domain.Movie;
import com.stackroute.MovieApp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    MovieRepository movieRepository;
    Movie movie;

    @Autowired
    public StartupApplicationListener(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Entered DB Seeding using ApplicationListener");
        movie = new Movie(1,"One","Synopsis of the movie","tagline of the movie",9.99);
        movieRepository.save(movie);
        movie = new Movie(2,"Two","Synopsis of the movie","tagline of the movie",9.99);
        movieRepository.save(movie);
    }
}
