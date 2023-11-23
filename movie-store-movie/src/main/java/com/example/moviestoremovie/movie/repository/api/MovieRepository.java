package com.example.moviestoremovie.movie.repository.api;

import com.example.moviestoremovie.movie.entity.Movie;
import com.example.moviestoremovie.studio.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findAllByStudio(Studio studio);

}
