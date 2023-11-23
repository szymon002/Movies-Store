package com.example.gateway;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${moviestore.movie.url}") String movieUrl,
			@Value("${moviestore.studio.url}") String studioUrl,
			@Value("${moviestore.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("movies", route -> route
						.host(host)
						.and()
						.path(
								"/api/movies/{uuid}",
								"/api/movies",
								"/api/studios/{uuid}/movies"
						)
						.uri(movieUrl)
				)
				.route("studios", route -> route
						.host(host)
						.and()
						.path(
								"/api/studios/{uuid}",
								"/api/studios"
						)
						.uri(studioUrl)
				)
				.build();
	}

}
