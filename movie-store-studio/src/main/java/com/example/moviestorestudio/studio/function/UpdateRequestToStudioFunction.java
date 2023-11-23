package com.example.moviestorestudio.studio.function;

import com.example.moviestorestudio.studio.dto.PatchStudioRequest;
import com.example.moviestorestudio.studio.entity.Studio;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class UpdateRequestToStudioFunction implements BiFunction<UUID, PatchStudioRequest, Studio> {

    @Override
    public Studio apply(UUID uuid, PatchStudioRequest patchStudioRequest) {
        return Studio.builder()
                .id(uuid)
                .numberOfWorkers(patchStudioRequest.getNumberOfWorkers())
                .yearsOfExperience(patchStudioRequest.getYearsOfExperience())
                .owner(patchStudioRequest.getOwner())
                .name(patchStudioRequest.getName())
                .build();
    }
}
