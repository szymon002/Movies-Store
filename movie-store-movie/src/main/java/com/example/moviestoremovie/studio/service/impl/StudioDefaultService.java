package com.example.moviestoremovie.studio.service.impl;

import com.example.moviestoremovie.studio.entity.Studio;
import com.example.moviestoremovie.studio.repository.api.StudioRepository;
import com.example.moviestoremovie.studio.service.api.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudioDefaultService implements StudioService {

    private final StudioRepository repository;

    @Autowired
    public StudioDefaultService(StudioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Studio> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void create(Studio studio) {
        if (repository.findById(studio.getId()).isEmpty()) {
            repository.save(studio);
        }
    }

    @Override
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
    }
}
