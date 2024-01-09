package com.example.moviestoremovie.movie.function;

import com.example.moviestoremovie.movie.dto.PatchMovieRequest;
import com.example.moviestoremovie.movie.entity.Movie;
import com.example.moviestoremovie.studio.entity.Studio;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateRequestToMovieFunction implements BiFunction<UUID, PatchMovieRequest, Movie> {
    @Override
    public Movie apply(UUID uuid, PatchMovieRequest patchMovieRequest) {
        return Movie.builder()
                .id(uuid)
                .title(patchMovieRequest.getTitle())
                .director(patchMovieRequest.getDirector())
                .publisher(patchMovieRequest.getPublisher())
                .yearOfPublication(patchMovieRequest.getYearOfPublication())
                .studio(Studio.builder()
                    .id(patchMovieRequest.getStudioId())
                    .build())
                .build();
    }
}