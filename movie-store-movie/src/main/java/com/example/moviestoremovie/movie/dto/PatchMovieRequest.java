package com.example.moviestoremovie.movie.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchMovieRequest {
    String title;
    String director;
    String publisher;
    int yearOfPublication;
}
