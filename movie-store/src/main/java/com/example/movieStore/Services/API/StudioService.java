package com.example.movieStore.Services.API;

import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Entities.Studio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudioService {

    void create(Studio studio);
    List<Studio> getAll();

    Optional<Studio> find(UUID id);

    void deleteById(UUID id);

    void update(Studio studio);
}
