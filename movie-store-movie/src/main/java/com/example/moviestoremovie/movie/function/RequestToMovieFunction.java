package com.example.moviestoremovie.movie.function;

import com.example.moviestoremovie.movie.dto.PutMovieRequest;
import com.example.moviestoremovie.movie.entity.Movie;
import com.example.moviestoremovie.studio.entity.Studio;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMovieFunction implements BiFunction<UUID, PutMovieRequest, Movie> {

    @Override
    public Movie apply(UUID id, PutMovieRequest request) {
        return Movie.builder()
                .id(id)
                .title(request.getTitle())
                .director(request.getDirector())
                .publisher(request.getPublisher())
                .yearOfPublication(request.getYearOfPublication())
                .studio(Studio.builder()
                        .id(request.getStudio())
                        .build())
                .build();
    }

}
