package com.example.movieStore.DTO;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetStudioResponse {

    UUID id;
    String name;
    int numberOfWorkers;
    int yearsOfExperience;
    String owner;

}
