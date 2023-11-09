package com.example.movieStore.Initialize;

import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Services.API.MovieService;
import com.example.movieStore.Services.API.StudioService;
import com.example.movieStore.Entities.Studio;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InitializeData implements InitializingBean {

    private final MovieService movieService;
    private final StudioService studioService;

    @Autowired
    public InitializeData(
            MovieService movieService,
            StudioService studioService
    ) {
        this.movieService = movieService;
        this.studioService = studioService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Studio studio1 = new Studio();
        studio1.setName("Magic Library");
        studio1.setOwner("Jack Jacson");
        studio1.setNumberOfWorkers(30);
        studio1.setYearsOfExperience(5);

        Studio studio2 = new Studio();
        studio2.setName("Horror Library");
        studio2.setOwner("Michael Scott");
        studio2.setNumberOfWorkers(20);
        studio2.setYearsOfExperience(3);

        Movie movie1 = new Movie();
        movie1.setTitle("Harry Potter 1");
        movie1.setDirector("J.K. Rowling");
        movie1.setPublisher("MagicWorld");
        movie1.setYearOfPublication(2003);
        movie1.setStudio(studio1);

        Movie movie2 = new Movie();
        movie2.setTitle("Harry Potter 2");
        movie2.setDirector("J.K. Rowling");
        movie2.setPublisher("MagicWorld");
        movie2.setYearOfPublication(2005);
        movie2.setStudio(studio1);

        Movie movie3 = new Movie();
        movie3.setTitle("Harry Potter 3");
        movie3.setDirector("J.K. Rowling");
        movie3.setPublisher("MagicWorld");
        movie3.setYearOfPublication(2008);
        movie3.setStudio(studio1);

        Movie movie4 = new Movie();
        movie4.setTitle("Halloween");
        movie4.setDirector("Steven King");
        movie4.setPublisher("Horrors");
        movie4.setYearOfPublication(2015);
        movie4.setStudio(studio2);

        Movie movie5 = new Movie();
        movie5.setTitle("IT");
        movie5.setDirector("Steven King");
        movie5.setPublisher("Horrors");
        movie5.setYearOfPublication(2010);
        movie5.setStudio(studio2);

        studio1.setMovies(Arrays.asList(movie1, movie2, movie3));
        studio2.setMovies(Arrays.asList(movie4, movie5));

        studioService.create(studio1);
        studioService.create(studio2);
        movieService.createAll(Arrays.asList(movie1, movie2, movie3, movie4, movie5));
    }

}
