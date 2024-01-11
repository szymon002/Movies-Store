package com.example.moviestorestudio.studio.service.impl;

import com.example.moviestorestudio.studio.entity.Studio;
import com.example.moviestorestudio.studio.event.repository.api.StudioEventRepository;
import com.example.moviestorestudio.studio.repository.api.StudioRepository;
import com.example.moviestorestudio.studio.service.api.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudioDefaultService implements StudioService {

    private final StudioRepository repository;

    private final StudioEventRepository eventRepository;
    @Autowired
    public StudioDefaultService(StudioRepository repository, StudioEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void create(Studio studio) {
        repository.save(studio);
        eventRepository.create(studio.getId(), studio);
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
    public void delete(UUID id) {
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

    @Override
    public void update(Studio studio) {
        repository.save(studio);
    }

}
