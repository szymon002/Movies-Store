package com.example.moviestoremovie.studio.repository.api;

import com.example.moviestoremovie.studio.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudioRepository extends JpaRepository<Studio, UUID> {

}
