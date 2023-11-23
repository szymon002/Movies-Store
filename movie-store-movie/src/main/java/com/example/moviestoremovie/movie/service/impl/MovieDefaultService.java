package com.example.moviestoremovie.movie.service.impl;

import com.example.moviestoremovie.movie.entity.Movie;
import com.example.moviestoremovie.movie.repository.api.MovieRepository;
import com.example.moviestoremovie.movie.service.api.MovieService;
import com.example.moviestoremovie.studio.repository.api.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieDefaultService implements MovieService {

    private final MovieRepository repository;
    private final StudioRepository studioRepository;

    @Autowired
    public MovieDefaultService(
            MovieRepository repository,
            StudioRepository studioRepository

    ) {
        this.repository = repository;
        this.studioRepository = studioRepository;
    }

    @Override
    public Optional<List<Movie>> findAllByStudio(UUID id) {
        return studioRepository.findById(id)
                .map(repository::findAllByStudio);
    }

    @Override
    public void create(Movie movie) {
        repository.save(movie);
    }

    @Override
    public void createAll(List<Movie> movies) {
        repository.saveAll(movies);
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public List<Movie> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void update(Movie movie) {
        repository.save(movie);
    }
}
