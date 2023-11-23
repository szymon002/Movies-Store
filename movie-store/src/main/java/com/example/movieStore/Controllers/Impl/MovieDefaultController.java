package com.example.movieStore.Controllers.Impl;

import com.example.movieStore.Controllers.API.MovieController;
import com.example.movieStore.DTO.*;
import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Functions.MovieToResponseFunction;
import com.example.movieStore.Functions.MoviesToResponseFunction;
import com.example.movieStore.Functions.RequestToMovieFunction;
import com.example.movieStore.Functions.UpdateRequestToMovieFunction;
import com.example.movieStore.Services.API.MovieService;
import com.example.movieStore.Services.API.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@RestController
public class MovieDefaultController implements MovieController {

    final MovieService service;
    final StudioService studioService;
    final MovieToResponseFunction movieToResponse;
    final MoviesToResponseFunction moviesToResponse;
    final RequestToMovieFunction requestToMovie;
    final UpdateRequestToMovieFunction requestUpdateToMovie;

    @Autowired
    public MovieDefaultController(MovieService service,
                                  StudioService studioService, MovieToResponseFunction movieToResponse,
                                  MoviesToResponseFunction moviesToResponse,
                                  RequestToMovieFunction requestToMovie,
                                  UpdateRequestToMovieFunction requestUpdateToMovie) {
        this.service = service;
        this.studioService = studioService;
        this.movieToResponse = movieToResponse;
        this.moviesToResponse = moviesToResponse;
        this.requestToMovie = requestToMovie;
        this.requestUpdateToMovie = requestUpdateToMovie;
    }

    @Override
    public GetMoviesResponse getMovies() {
        return moviesToResponse.apply(service.getAll());
    }

    @Override
    public GetMoviesResponse getStudioMovies(UUID studioId) {
        return service.findAllByStudio(studioId)
                .map(moviesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMovieResponse getMovie(UUID id) {
        return service.find(id)
                .map(movieToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putMovie(UUID id, PutMovieRequest request) {
        service.create(requestToMovie.apply(id, request));
    }

    @Override
    public void deleteMovie(UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        movie -> service.deleteById(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

    @Override
    public void updateMovie(UUID id, PatchMovieRequest request) {
        Optional<Movie> existingMovie = service.find(id);

        if (existingMovie.isPresent()) {
            if (request.getYearOfPublication() == 0) {
                request.setYearOfPublication( existingMovie.get().getYearOfPublication());
            }

            if (request.getTitle() == null) {
                request.setTitle( existingMovie.get().getTitle());
            }

            if (request.getDirector() == null) {
                request.setDirector( existingMovie.get().getDirector());
            }

            if (request.getPublisher() == null) {
                request.setPublisher( existingMovie.get().getPublisher());
            }
        }

        service.update(requestUpdateToMovie.apply(id, request));
    }
}
