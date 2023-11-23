package com.example.moviestoremovie.studio.service.api;

import com.example.moviestoremovie.studio.entity.Studio;

import java.util.Optional;
import java.util.UUID;

public interface StudioService {

    Optional<Studio> find(UUID id);

    void create(Studio studio);

    void delete(UUID id);
}
