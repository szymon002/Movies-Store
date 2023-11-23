package com.example.movieStore.Functions;

import com.example.movieStore.DTO.GetMovieResponse;
import com.example.movieStore.DTO.GetMoviesResponse;
import com.example.movieStore.Entities.Movie;
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
                                .id(movie.getMovieId())
                                .title(movie.getTitle())
                                .build())
                        .toList())
                .build();
    }

}
