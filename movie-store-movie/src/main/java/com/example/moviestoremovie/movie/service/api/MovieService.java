package com.example.moviestoremovie.movie.service.api;

import com.example.moviestoremovie.movie.entity.Movie;
import com.example.moviestoremovie.studio.entity.Studio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {
    Optional<List<Movie>> findAllByStudio(UUID id);

    void create(Movie movie);

    void createAll(List<Movie> movies);

    void delete(UUID id);

    List<Movie> getAll();

    Optional<Movie> find(UUID id);
    void update(Movie movie);

}
