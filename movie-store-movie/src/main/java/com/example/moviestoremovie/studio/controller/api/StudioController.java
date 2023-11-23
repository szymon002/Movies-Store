package com.example.moviestoremovie.studio.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

public interface StudioController {

    @DeleteMapping("/api/studio/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteStudio(
            @PathVariable("id")
            UUID id
    );
}
