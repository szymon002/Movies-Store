package com.example.movieStore.Services.Impl;

import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Repositories.MovieRepository;
import com.example.movieStore.Repositories.StudioRepository;
import com.example.movieStore.Services.API.MovieService;
import com.example.movieStore.Entities.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository repository;
    private final StudioRepository studioRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository repository, StudioRepository studioRepository) {
        this.repository = repository;
        this.studioRepository = studioRepository;
    }

    @Override
    public List<Movie> findMoviesByStudio(Studio studio) {
        return repository.findByStudio(studio);
    }

    @Override
    public Optional<List<Movie>> findAllByStudio(UUID id) {
        return studioRepository.findById(id).map(repository::findByStudio);
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

    @Override
    public void delete(Movie movie) {
        repository.delete(movie);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
