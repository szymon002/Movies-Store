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
public class Studio implements Comparable<Studio>, Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Studio studio = (Studio) o;
        return numberOfWorkers == studio.numberOfWorkers && yearsOfExperience == studio.yearsOfExperience && Objects.equals(name, studio.name) && Objects.equals(owner, studio.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, owner, numberOfWorkers, yearsOfExperience);
    }

    @Override
    public String toString() {
        return "Studio{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", numberOfWorkers=" + numberOfWorkers +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    @Override
    public int compareTo(Studio o) {
        return Integer.compare(this.yearsOfExperience, o.yearsOfExperience);
    }
}
