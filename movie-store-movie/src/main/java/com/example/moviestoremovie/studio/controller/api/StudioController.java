package com.example.moviestoremovie.studio.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface StudioController {

    @DeleteMapping("/api/studios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteStudio(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/studios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void createStudio (
            @PathVariable("id")
            UUID id
    );
}
