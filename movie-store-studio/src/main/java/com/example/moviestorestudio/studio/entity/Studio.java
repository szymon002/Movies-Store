package com.example.moviestorestudio.studio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
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

    String name;
    String owner;

    int numberOfWorkers;

    int yearsOfExperience;
}
