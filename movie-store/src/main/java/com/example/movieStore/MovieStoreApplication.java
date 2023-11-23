package com.example.movieStore;

import com.example.movieStore.Initialize.InitializeData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationContext;

import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@SpringBootApplication
public class MovieStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieStoreApplication.class, args);
	}


	/*public static void Labs1() {
		Studio studio1 = Studio.builder().name("Magic Library").owner("Jack Jacson")
				.numberOfWorkers(30).yearsOfExperience(5).build();
		Studio studio2 = Studio.builder().name("Horror Library").owner("Michael Scott")
				.numberOfWorkers(20).yearsOfExperience(3).build();
		Movie movie1 = Movie.builder().title("Harry Potter 1").director("J.K. Rowling")
				.publisher("MagicWorld").yearOfPublication(2003).studio(studio1).build();
		Movie movie2 = Movie.builder().title("Harry Potter 2").director("J.K. Rowling")
				.publisher("MagicWorld").yearOfPublication(2005).studio(studio1).build();
		Movie movie3 = Movie.builder().title("Harry Potter 3").director("J.K. Rowling")
				.publisher("MagicWorld").yearOfPublication(2008).studio(studio1).build();
		Movie movie4 = Movie.builder().title("Halloween").director("Steven King")
				.publisher("Horrors").yearOfPublication(2015).studio(studio2).build();
		Movie movie5 = Movie.builder().title("IT").director("Steven King")
				.publisher("Horrors").yearOfPublication(2010).studio(studio2).build();

		List<Movie> magicMovies = Arrays.asList(movie1, movie2, movie3);
		List<Movie> horrorMovies = Arrays.asList(movie4, movie5);
		studio1.setMovies(magicMovies);
		studio2.setMovies(horrorMovies);

		System.out.println("Exercise 2");
		List<Studio> libraries = Arrays.asList(studio1, studio2);
		for (Studio studio : libraries) {
			System.out.println(studio.toString());
			for (Movie movie : studio.getMovies()) {
				System.out.println(movie.toString());
			}
		}

		System.out.println("Exercise 3 & 4");
		Set<Movie> booksSet = libraries.stream()
				.flatMap(studio -> studio.getMovies().stream())
				.collect(Collectors.toSet());
		booksSet.forEach(movie -> System.out.println(movie.toString()));

		booksSet.stream()
				.filter(movie -> movie.getTitle().startsWith("H"))
				.sorted(Comparator.comparing(Movie::getYearOfPublication))
				.forEach(movie -> System.out.println(movie.toString()));


		System.out.println("Exercise 5");
		ModelMapper modelMapper = new ModelMapper();
		List<MovieDTO> booksDTO = booksSet.stream()
				.map(movieDTO -> modelMapper.map(movieDTO, MovieDTO.class))
				.sorted()
				.toList();
		booksDTO.forEach(movieDTO -> System.out.println(movieDTO.toString()));

		System.out.println("Exercise 6");
		try {
			FileOutputStream file = new FileOutputStream("libraries.bin");
			ObjectOutputStream outputStream = new ObjectOutputStream(file);
			for (Studio studio : libraries) {
				outputStream.writeObject(studio);
			}
			outputStream.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Studio> librariesFromFile = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream("libraries.bin");
			ObjectInputStream inputStream = new ObjectInputStream(file);
			while (true) {
				try {
					librariesFromFile.add((Studio) inputStream.readObject());
				} catch (EOFException e) {
					break;
				}
			}
			inputStream.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		for (Studio studio : librariesFromFile) {
			System.out.println(studio.toString());
			for (Movie movie : studio.getMovies()) {
				System.out.println(movie.toString());
			}
		}

		System.out.println("Exercise 7");

		ForkJoinPool customPool = new ForkJoinPool(4);
		librariesFromFile.parallelStream()
				.forEach(studio -> {
					customPool.execute(() -> {
						studio.getMovies().forEach(movie -> {
							System.out.println(movie.toString());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								throw new RuntimeException(e);
							}
						});
					});
				});

		try {
			customPool.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/

}
