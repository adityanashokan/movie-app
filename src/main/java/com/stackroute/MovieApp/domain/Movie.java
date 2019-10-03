package com.stackroute.MovieApp.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    private int movieId;
    private String movieName;
    private String overview;
    private String tagline;
    private double vote_average;


    public Movie() {
    }

    public Movie(int movieId, String movieName, String overview, String tagline, double vote_average) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.overview = overview;
        this.tagline = tagline;
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", overview='" + overview + '\'' +
                ", tagline='" + tagline + '\'' +
                ", vote_average=" + vote_average +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

}
