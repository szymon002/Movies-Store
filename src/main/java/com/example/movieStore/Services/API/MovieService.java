package com.example.movieStore.Services.API;

import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Entities.Studio;
import java.util.Optional;


import java.util.List;
import java.util.UUID;

public interface MovieService {
    List<Movie> findMoviesByStudio(Studio studio);

    Optional<List<Movie>> findAllByStudio(UUID id);

    void create(Movie movie);

    void createAll(List<Movie> movie);

    void delete(Movie movie);

    void deleteById(UUID id);

    List<Movie> getAll();

    Optional<Movie> find(UUID id);
}
