package com.example.moviestorestudio.studio.event.repository.api;

import com.example.moviestorestudio.studio.entity.Studio;

import java.util.UUID;

public interface StudioEventRepository {

    void delete(UUID id);

    void create(UUID id, Studio studio);
}
