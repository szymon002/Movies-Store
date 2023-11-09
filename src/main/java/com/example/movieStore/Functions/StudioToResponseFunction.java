package com.example.movieStore.Functions;

import com.example.movieStore.DTO.GetStudioResponse;
import com.example.movieStore.Entities.Studio;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StudioToResponseFunction implements Function<Studio, GetStudioResponse> {
    @Override
    public GetStudioResponse apply(Studio studio) {
        return GetStudioResponse.builder()
                .id(studio.getStudioId())
                .name(studio.getName())
                .build();
    }
}
