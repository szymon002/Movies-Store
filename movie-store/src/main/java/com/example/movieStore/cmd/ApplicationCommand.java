package com.example.movieStore.cmd;

import com.example.movieStore.Initialize.InitializeData;
import com.example.movieStore.Entities.Movie;
import com.example.movieStore.Services.API.MovieService;
import com.example.movieStore.Services.API.StudioService;
import com.example.movieStore.Entities.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class ApplicationCommand implements CommandLineRunner {
    private final MovieService movieService;
    private final StudioService studioService;

    @Autowired
    public ApplicationCommand(MovieService movieService, StudioService studioService) {
        this.movieService = movieService;
        this.studioService = studioService;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        int chosenStudioNumber;
        boolean stop = false;
        while(!stop) {
            System.out.print("Enter a command: ");
            command = scanner.next();
            switch(command) {
                case "list" -> {
                    System.out.println("Available Commands:");
                    System.out.println("get_movies");
                    System.out.println("get_studios");
                    System.out.println("add_movie");
                    System.out.println("delete_movie");
                    System.out.println("quit");
                }
                case "get_movies" -> {
                    for (Movie movie : movieService.getAll()) {
                        System.out.println(movie.toString());
                    }
                }
                case "get_studios" -> {
                    for (Studio studio : studioService.getAll()) {
                        System.out.println(studio.toString());
                        System.out.println("Movies:");
                        for (Movie movie : movieService.findMoviesByStudio(studio)) {
                            System.out.println(movie.toString());
                        }
                    }
                }
                case "add_movie" -> {
                    Studio chosenStudio;
                    String movieTitle;
                    String movieDirector;
                    String moviePublisher;
                    int movieYearOfPublication;
                    List<Studio> studioList = studioService.getAll();
                    Map<Integer, Studio> numberToStudio = new HashMap<>();
                    for (int i = 0; i < studioList.size(); i++) {
                        numberToStudio.put(i, studioList.get(i));
                    }
                    for (int i = 0; i < studioList.size(); i++) {
                        System.out.println(i + "." + studioList.get(i).toString());
                    }
                    System.out.println("choose studio number");
                    chosenStudioNumber = scanner.nextInt();
                    chosenStudio = numberToStudio.get(chosenStudioNumber);
                    System.out.println("Write movie title");
                    movieTitle = scanner.next();
                    System.out.println("Write movie director");
                    movieDirector= scanner.next();
                    System.out.println("Write movie publisher");
                    moviePublisher = scanner.next();
                    System.out.println("Write movie year of publication");
                    movieYearOfPublication= scanner.nextInt();
                    Movie movie = new Movie();
                    movie.setTitle(movieTitle);
                    movie.setDirector(movieDirector);
                    movie.setPublisher(moviePublisher);
                    movie.setYearOfPublication(movieYearOfPublication);
                    movie.setStudio(chosenStudio);
                    movieService.create(movie);
                }
                case "delete_movie" -> {
                    int chosenMovieNumber;
                    Movie chosenMovie;
                    List<Movie> movieList = movieService.getAll();
                    Map<Integer, Movie> numberToMovie = new HashMap<>();

                    for (int i = 0; i < movieList.size(); i++) {
                        numberToMovie.put(i, movieList.get(i));
                    }

                    for (int i = 0; i < movieList.size(); i++) {
                        System.out.println(i + "." + numberToMovie.get(i).toString());
                    }
                    System.out.println("choose movie number");
                    chosenMovieNumber = scanner.nextInt();
                    chosenMovie = numberToMovie.get(chosenMovieNumber);
                    movieService.delete(chosenMovie);
                }
                case "quit" ->  {
                    stop = true;
                }
            }
        }

        System.out.println("Closing application");
    }
}
