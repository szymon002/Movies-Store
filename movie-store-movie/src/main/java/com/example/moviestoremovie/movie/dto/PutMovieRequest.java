package com.example.moviestoremovie.movie.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutMovieRequest {
    String title;
    String director;
    String publisher;

    int yearOfPublication;

    UUID studio;
}
