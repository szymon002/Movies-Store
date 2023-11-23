package com.example.moviestorestudio.studio.controller.api;

import com.example.moviestorestudio.studio.dto.GetStudioResponse;
import com.example.moviestorestudio.studio.dto.GetStudiosResponse;
import com.example.moviestorestudio.studio.dto.PatchStudioRequest;
import com.example.moviestorestudio.studio.dto.PutStudioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface StudioController {

    @GetMapping("/api/studios")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetStudiosResponse getStudios();

    @GetMapping("/api/studios/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetStudioResponse getStudio(
            @PathVariable("id")
            UUID id
    );

    @DeleteMapping("/api/studios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteStudio(
            @PathVariable("id")
            UUID id
    );

    @PatchMapping("/api/studios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void updateStudio(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchStudioRequest request
    );

    @PutMapping("/api/studios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void createStudio (
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutStudioRequest request
    );

}