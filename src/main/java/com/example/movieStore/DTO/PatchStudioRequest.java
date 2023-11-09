package com.example.movieStore.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PatchStudioRequest {

    int numberOfWorkers;
    int yearsOfExperience;
    String owner;
}
