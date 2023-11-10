package com.example.movieStore.Functions;

import com.example.movieStore.DTO.PatchMovieRequest;
import com.example.movieStore.DTO.PatchStudioRequest;
import com.example.movieStore.Entities.Studio;
import org.springframework.stereotype.Component;

import com.example.movieStore.Entities.Movie;
import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateRequestToMovieFunction implements BiFunction<UUID, PatchMovieRequest, Movie> {
    @Override
    public Movie apply(UUID uuid, PatchMovieRequest patchMovieRequest) {
        return Movie.builder()
                .movieId(uuid)
                .title(patchMovieRequest.getTitle())
                .director(patchMovieRequest.getDirector())
                .publisher(patchMovieRequest.getPublisher())
                .yearOfPublication(patchMovieRequest.getYearOfPublication())
                .build();
    }
}
