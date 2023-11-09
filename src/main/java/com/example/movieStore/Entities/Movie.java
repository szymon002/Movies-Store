package com.example.movieStore.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie implements Comparable<Movie>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID movieId;

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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return yearOfPublication == movie.yearOfPublication && Objects.equals(title, movie.title) && Objects.equals(director, movie.director) && Objects.equals(publisher, movie.publisher) && Objects.equals(studio, movie.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, publisher, yearOfPublication, studio);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", publisher='" + publisher + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                "studio=" + studio.name +
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return Integer.compare(this.yearOfPublication, o.yearOfPublication);
    }
}
