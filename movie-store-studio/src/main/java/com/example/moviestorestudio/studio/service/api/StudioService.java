package com.example.moviestorestudio.studio.service.api;

import com.example.moviestorestudio.studio.entity.Studio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudioService {

    void create(Studio studio);
    List<Studio> getAll();

    Optional<Studio> find(UUID id);

    void delete(UUID id);

    void update(Studio studio);
}