package com.example.moviestorestudio.studio.function;

import com.example.moviestorestudio.studio.dto.GetStudiosResponse;
import com.example.moviestorestudio.studio.entity.Studio;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class StudiosToResponseFunction implements Function<List<Studio>, GetStudiosResponse> {

    @Override
    public GetStudiosResponse apply(List<Studio> entities) {
        return GetStudiosResponse.builder()
                .studios(entities.stream()
                        .map(studio -> GetStudiosResponse.Studio.builder()
                                .id(studio.getId())
                                .name(studio.getName())
                                .build())
                        .toList())
                .build();
    }
}

