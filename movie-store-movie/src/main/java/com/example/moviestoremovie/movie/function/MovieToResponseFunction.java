package com.example.moviestoremovie.movie.function;

import com.example.moviestoremovie.movie.dto.GetMovieResponse;
import com.example.moviestoremovie.movie.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MovieToResponseFunction implements Function<Movie, GetMovieResponse> {

    @Override
    public GetMovieResponse apply(Movie entity) {
        return GetMovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .director(entity.getDirector())
                .publisher(entity.getPublisher())
                .yearOfPublication(entity.getYearOfPublication())
                .studio(GetMovieResponse.Studio.builder()
                        .id(entity.getStudio().getId())
                        .build())
                .build();
    }

}
