package com.example.movieStore.Functions;

import com.example.movieStore.DTO.GetStudioResponse;
import com.example.movieStore.DTO.GetStudiosResponse;
import com.example.movieStore.Entities.Studio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


@Component
public class StudiosToResponseFunction implements Function<List<Studio>, GetStudiosResponse>{

    @Override
    public GetStudiosResponse apply(List<Studio> entities) {
        return GetStudiosResponse.builder()
                .studios(entities.stream()
                        .map(studio -> GetStudiosResponse.Studio.builder()
                                .id(studio.getStudioId())
                                .name(studio.getName())
                                .build())
                        .toList())
                .build();
    }
}
