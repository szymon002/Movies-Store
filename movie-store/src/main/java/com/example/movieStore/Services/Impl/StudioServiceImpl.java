package com.example.movieStore.Services.Impl;

import com.example.movieStore.Repositories.MovieRepository;
import com.example.movieStore.Repositories.StudioRepository;
import com.example.movieStore.Services.API.StudioService;
import com.example.movieStore.Entities.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudioServiceImpl implements StudioService {

    private final StudioRepository repository;
    @Autowired
    public StudioServiceImpl(StudioRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Studio studio) {
        repository.save(studio);
    }

    @Override
    public List<Studio> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Studio> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }

    @Override
    public void update(Studio studio) {
        repository.save(studio);
    }

}
