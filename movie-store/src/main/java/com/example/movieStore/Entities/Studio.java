package com.example.movieStore.Entities;

import com.example.movieStore.Services.API.MovieService;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@Table(name = "studios")
public class Studio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID studioId;

    @Column(name = "studio_name")
    String name;

    @Column(name = "studio_owner")
    String owner;

    @Column(name = "number_of_workers")
    int numberOfWorkers;

    @Column(name = "years_of_experience")
    int yearsOfExperience;

    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL)
    List<Movie> movies;

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
}
