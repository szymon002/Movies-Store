package com.example.movieStore.Controllers.Impl;

import com.example.movieStore.Controllers.API.StudioController;
import com.example.movieStore.DTO.GetStudioResponse;
import com.example.movieStore.DTO.GetStudiosResponse;
import com.example.movieStore.DTO.PatchStudioRequest;
import com.example.movieStore.Entities.Studio;
import com.example.movieStore.Functions.*;
import com.example.movieStore.Services.API.StudioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.sound.midi.Patch;
import java.util.Optional;
import java.util.UUID;

@RestController
public class StudioDefaultController implements StudioController {
    final StudioService service;
    final StudioToResponseFunction studioToResponse;
    final StudiosToResponseFunction studiosToResponse;
    final UpdateRequestToStudioFunction requestToStudio;


    public StudioDefaultController(StudioService service,
                                   StudioToResponseFunction studioToResponse,
                                   StudiosToResponseFunction studiosToResponse,
                                   UpdateRequestToStudioFunction requestToStudio) {
        this.service = service;
        this.studioToResponse = studioToResponse;
        this.studiosToResponse = studiosToResponse;
        this.requestToStudio = requestToStudio;
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

    @Override
    public void updateStudio(UUID id, PatchStudioRequest request) {
        Optional<Studio> existingStudio = service.find(id);

        if (existingStudio.isPresent()) {
            if (request.getNumberOfWorkers() == 0) {
                request.setNumberOfWorkers(existingStudio.get().getNumberOfWorkers());
            }

            if (request.getYearsOfExperience() == 0) {
                request.setYearsOfExperience(existingStudio.get().getYearsOfExperience());
            }

            if (request.getOwner() == null) {
                request.setOwner(existingStudio.get().getOwner());
            }

            if (request.getName() == null) {
                request.setName(existingStudio.get().getName());
            }
        }

        service.update(requestToStudio.apply(id, request));
    }
}
