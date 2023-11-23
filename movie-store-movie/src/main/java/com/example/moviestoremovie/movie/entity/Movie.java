package com.example.moviestoremovie.movie.entity;

import com.example.moviestoremovie.studio.entity.Studio;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "movie_title")
    String title;

    @Column(name = "movie_director")
    String director;

    @Column(name = "movie_publisher")
    String publisher;

    @Column(name = "year_of_publication")
    int yearOfPublication;

    @ManyToOne
    @JoinColumn(name = "studio")
    Studio studio;

}

