package com.example.moviestorestudio.studio.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PutStudioRequest {
    int numberOfWorkers;
    int yearsOfExperience;
    String owner;
    String name;
}
