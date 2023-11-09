package com.example.movieStore.Functions;

import com.example.movieStore.DTO.GetMovieResponse;
import com.example.movieStore.DTO.GetMoviesResponse;
import com.example.movieStore.DTO.PutMovieRequest;
import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Entities.Studio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class RequestToMovieFunction implements BiFunction<UUID, PutMovieRequest, Movie> {

    @Override
    public Movie apply(UUID id, PutMovieRequest request) {
        return Movie.builder()
                .movieId(id)
                .title(request.getTitle())
                .director(request.getDirector())
                .publisher(request.getPublisher())
                .yearOfPublication(request.getYearOfPublication())
                .studio(Studio.builder()
                        .studioId(request.getStudio())
                        .build())
                .build();
    }

}
