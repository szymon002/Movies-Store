package com.example.moviestorestudio.studio.controller.impl;

import com.example.moviestorestudio.studio.controller.api.StudioController;
import com.example.moviestorestudio.studio.dto.GetStudioResponse;
import com.example.moviestorestudio.studio.dto.GetStudiosResponse;
import com.example.moviestorestudio.studio.dto.PatchStudioRequest;
import com.example.moviestorestudio.studio.dto.PutStudioRequest;
import com.example.moviestorestudio.studio.function.RequestToStudioFunction;
import com.example.moviestorestudio.studio.function.StudioToResponseFunction;
import com.example.moviestorestudio.studio.function.StudiosToResponseFunction;
import com.example.moviestorestudio.studio.function.UpdateRequestToStudioFunction;
import com.example.moviestorestudio.studio.service.api.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.moviestorestudio.studio.entity.Studio;

import java.util.Optional;
import java.util.UUID;

@RestController
public class StudioDefaultController implements StudioController {

    final StudioService service;
    final StudioToResponseFunction studioToResponse;
    final StudiosToResponseFunction studiosToResponse;
    final UpdateRequestToStudioFunction requestToStudio;
    final RequestToStudioFunction createRequestToStudio;


    @Autowired
    public StudioDefaultController(StudioService service,
                                   StudioToResponseFunction studioToResponse,
                                   StudiosToResponseFunction studiosToResponse,
                                   UpdateRequestToStudioFunction requestToStudio,
                                   RequestToStudioFunction createRequestToStudio
    ) {
        this.service = service;
        this.studioToResponse = studioToResponse;
        this.studiosToResponse = studiosToResponse;
        this.requestToStudio = requestToStudio;
        this.createRequestToStudio = createRequestToStudio;
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
                        studio -> service.delete(id),
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

    @Override
    public void createStudio(UUID id, PutStudioRequest request) {
        service.create(createRequestToStudio.apply(id, request));
    }
}
