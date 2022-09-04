package com.movie.MovieShowCase.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Movie {

    @Id
    private UUID id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String overview;
    private String poster;
    private String releaseDate;
    private String director;
    private Integer maturity_level_id;

}
