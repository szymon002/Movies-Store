package com.example.moviestoremovie.studio.entity;

import com.example.moviestoremovie.movie.entity.Movie;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "studios")
public class Studio implements Serializable {
    @Id
    UUID id;

    @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL)
    List<Movie> movies;
}
