package com.example.moviestorestudio.studio.event.repository.rest;

import com.example.moviestorestudio.studio.entity.Studio;
import com.example.moviestorestudio.studio.event.repository.api.StudioEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class StudioEventRestRepository implements StudioEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public StudioEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }
    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/studios/{id}", id);
    }

    @Override
    public void create(UUID id, Studio studio) {
        restTemplate.put("/api/studios/{id}", studio, id);
    }
}
