package com.example.movieStore.Functions;

import com.example.movieStore.DTO.PatchStudioRequest;
import com.example.movieStore.DTO.PutMovieRequest;
import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Entities.Studio;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateRequestToStudioFunction implements BiFunction<UUID, PatchStudioRequest, Studio> {

    @Override
    public Studio apply(UUID uuid, PatchStudioRequest patchStudioRequest) {
        return Studio.builder()
                .studioId(uuid)
                .numberOfWorkers(patchStudioRequest.getNumberOfWorkers())
                .yearsOfExperience(patchStudioRequest.getYearsOfExperience())
                .owner(patchStudioRequest.getOwner())
                .name(patchStudioRequest.getName())
                .build();
    }
}
