package com.example.movieStore.Repositories;

import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByStudio(Studio studio);

}
