package com.movie.MovieShowCase.Service;

import com.movie.MovieShowCase.Entity.Dto.MovieList;
import com.movie.MovieShowCase.Entity.Movie;
import com.movie.MovieShowCase.Repository.MovieRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements  MovieService{

    private final EurekaClient eurekaClient;
    private final MovieRepository movieRepository;

    @Value("${spring.application.name}")
    private  String eurekaHostName;
    @Override
    public List<Movie> getAllMovies() {

        RestTemplate restTemplate = new RestTemplate();
        InstanceInfo info = eurekaClient.getNextServerFromEureka(eurekaHostName,false);
        String url = info.getHomePageUrl();
        url = url + "/movie/list";
        MovieList list = restTemplate.getForObject(url, MovieList.class);
        List<Movie> getAllMovies = list.getMovieList();

        return getAllMovies;
    }

    @Override
    public List<Movie> getAllMoviesCB() {

        List<Movie> getAllMoviesCB = movieRepository.findAll();
        return getAllMoviesCB;
    }

}
