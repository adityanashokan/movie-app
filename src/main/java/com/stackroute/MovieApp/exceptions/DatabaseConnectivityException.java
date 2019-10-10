package com.stackroute.MovieApp.exceptions;

public class DatabaseConnectivityException extends Exception {
    private String message;
    public DatabaseConnectivityException() {
    }

    public DatabaseConnectivityException(String message) {
        super(message);
        this.message = message;
    }
}
