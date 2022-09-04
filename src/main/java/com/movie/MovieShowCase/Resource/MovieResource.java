package com.movie.MovieShowCase.Resource;

import com.movie.MovieShowCase.Entity.Movie;
import com.movie.MovieShowCase.Service.MovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieResource {

    private final MovieService movieService;

    @GetMapping("/list")
    @HystrixCommand(fallbackMethod = "getAllMoviesCB")
    public ResponseEntity<List<Movie>> getALlMovies(){

        List<Movie> movieList = movieService.getAllMovies();

        return ResponseEntity.ok().body(movieList);
    }

    public ResponseEntity<List<Movie>> getAllMoviesCB(){
        List<Movie> movieList = movieService.getAllMoviesCB();
        return ResponseEntity.ok().body(movieList);
    }

}
