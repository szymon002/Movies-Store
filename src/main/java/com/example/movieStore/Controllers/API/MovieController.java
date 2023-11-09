package com.example.movieStore.Controllers.API;

import com.example.movieStore.DTO.GetMovieResponse;
import com.example.movieStore.DTO.GetMoviesResponse;
import com.example.movieStore.DTO.PutMovieRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface MovieController {

    @GetMapping("/api/movies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMoviesResponse getMovies();

    @GetMapping("/api/studios/{studioId}/movies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMoviesResponse getStudioMovies(
            @PathVariable("studioId")
            UUID studioId
    );

    @GetMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMovieResponse getMovie(
            @PathVariable("id")
            UUID id
    );

    @PutMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void putMovie(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PutMovieRequest request
    );

    @DeleteMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(
            @PathVariable("id")
            UUID id
    );

}
