package com.example.movieStore.Controllers.Impl;

import com.example.movieStore.Controllers.API.StudioController;
import com.example.movieStore.DTO.GetStudioResponse;
import com.example.movieStore.DTO.GetStudiosResponse;
import com.example.movieStore.Functions.*;
import com.example.movieStore.Services.API.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class StudioDefaultController implements StudioController {
    final StudioService service;
    final StudioToResponseFunction studioToResponse;
    final StudiosToResponseFunction studiosToResponse;


    public StudioDefaultController(StudioService service,
                                   StudioToResponseFunction studioToResponse,
                                   StudiosToResponseFunction studiosToResponse) {
        this.service = service;
        this.studioToResponse = studioToResponse;
        this.studiosToResponse = studiosToResponse;
    }

    @Override
    public GetStudiosResponse getStudios() {
        return studiosToResponse.apply(service.getAll());
    }

    @Override
    public GetStudioResponse getStudio(UUID id) {
        return service.find(id)
                .map(studioToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteStudio(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        studio -> service.deleteById(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
