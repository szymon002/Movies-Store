package com.example.movieStore.Controllers.API;

import com.example.movieStore.DTO.*;
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

}
