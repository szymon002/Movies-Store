package com.example.moviestoremovie.movie.controller.api;

import com.example.moviestoremovie.movie.dto.GetMovieResponse;
import com.example.moviestoremovie.movie.dto.GetMoviesResponse;
import com.example.moviestoremovie.movie.dto.PatchMovieRequest;
import com.example.moviestoremovie.movie.dto.PutMovieRequest;
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

    @PatchMapping("/api/movies/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    void updateMovie(
            @PathVariable("id")
            UUID id,
            @RequestBody
            PatchMovieRequest request
    );

}
