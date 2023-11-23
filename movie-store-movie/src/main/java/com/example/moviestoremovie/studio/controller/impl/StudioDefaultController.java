package com.example.moviestoremovie.studio.controller.impl;

import com.example.moviestoremovie.studio.controller.api.StudioController;
import com.example.moviestoremovie.studio.entity.Studio;
import com.example.moviestoremovie.studio.service.api.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class StudioDefaultController implements StudioController {

    private final StudioService service;

    @Autowired
    public StudioDefaultController(StudioService service) {
        this.service = service;
    }

    @Override
    public void deleteStudio(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        studio -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void createStudio(UUID id) {
        service.create(Studio.builder().id(id).build());
    }
}
