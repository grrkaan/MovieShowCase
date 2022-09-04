package com.movie.MovieShowCase.Service;

import com.movie.MovieShowCase.Entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();
    List<Movie> getAllMoviesCB();
}
