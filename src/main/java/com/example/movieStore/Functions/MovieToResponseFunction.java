package com.example.movieStore.Functions;

import com.example.movieStore.DTO.GetMovieResponse;
import com.example.movieStore.Entities.Movie;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MovieToResponseFunction implements Function<Movie, GetMovieResponse> {

    @Override
    public GetMovieResponse apply(Movie entity) {
        return GetMovieResponse.builder()
                .id(entity.getMovieId())
                .title(entity.getTitle())
                .director(entity.getDirector())
                .publisher(entity.getPublisher())
                .yearOfPublication(entity.getYearOfPublication())
                .studio(GetMovieResponse.Studio.builder()
                        .id(entity.getStudio().getStudioId())
                        .name(entity.getStudio().getName())
                        .build())
                .build();
    }

}
