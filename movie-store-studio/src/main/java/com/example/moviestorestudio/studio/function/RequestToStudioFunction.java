package com.example.moviestorestudio.studio.function;

import com.example.moviestorestudio.studio.dto.PutStudioRequest;
import org.springframework.stereotype.Component;
import com.example.moviestorestudio.studio.entity.Studio;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToStudioFunction implements BiFunction<UUID, PutStudioRequest, Studio> {
    @Override
    public Studio apply(UUID uuid, PutStudioRequest putStudioRequest) {
        return Studio.builder()
                .id(uuid)
                .numberOfWorkers(putStudioRequest.getNumberOfWorkers())
                .yearsOfExperience(putStudioRequest.getYearsOfExperience())
                .owner(putStudioRequest.getOwner())
                .name(putStudioRequest.getName())
                .build();
    }
}
