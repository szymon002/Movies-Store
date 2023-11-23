package com.example.movieStore.DTO;

import com.example.movieStore.Entities.Studio;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
