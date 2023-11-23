package com.example.moviestorestudio.studio.function;

import com.example.moviestorestudio.studio.dto.GetStudioResponse;
import com.example.moviestorestudio.studio.entity.Studio;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudioToResponseFunction implements Function<Studio, GetStudioResponse> {
    @Override
    public GetStudioResponse apply(Studio studio) {
        return GetStudioResponse.builder()
                .id(studio.getId())
                .name(studio.getName())
                .numberOfWorkers(studio.getNumberOfWorkers())
                .yearsOfExperience(studio.getYearsOfExperience())
                .owner(studio.getOwner())
                .build();
    }
}
