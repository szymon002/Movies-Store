package com.example.moviestorestudio.studio.initialize;

import com.example.moviestorestudio.studio.entity.Studio;
import com.example.moviestorestudio.studio.service.api.StudioService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

    private final StudioService service;

    public InitializeData(StudioService service) {
        this.service = service;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (service.getAll().isEmpty()) {
            Studio studio1 = Studio.builder()
                    .id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
                    .name("Magic Library")
                    .owner("Jack jackson")
                    .numberOfWorkers(30)
                    .yearsOfExperience(5)
                    .build();

            Studio studio2 = Studio.builder()
                    .id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
                    .name("Horror Library")
                    .owner("Michael Scott")
                    .numberOfWorkers(20)
                    .yearsOfExperience(3)
                    .build();

            service.create(studio1);
            service.create(studio2);
        }
    }

}
