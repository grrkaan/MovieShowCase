package com.movie.MovieShowCase.Entity.Dto;

import com.movie.MovieShowCase.Entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class MovieList {

    private List<Movie> movieList;

}
