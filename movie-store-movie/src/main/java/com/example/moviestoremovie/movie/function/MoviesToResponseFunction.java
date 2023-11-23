package com.example.moviestoremovie.movie.function;

import com.example.moviestoremovie.movie.dto.GetMoviesResponse;
import com.example.moviestoremovie.movie.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class MoviesToResponseFunction implements Function<List<Movie>, GetMoviesResponse> {

    @Override
    public GetMoviesResponse apply(List<Movie> entities) {
        return GetMoviesResponse.builder()
                .movies(entities.stream()
                        .map(movie -> GetMoviesResponse.Movie.builder()
                                .id(movie.getId())
                                .title(movie.getTitle())
                                .build())
                        .toList())
                .build();
    }

}
