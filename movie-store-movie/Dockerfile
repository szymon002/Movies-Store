FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="movie-store-movie"
LABEL org.opencontainers.image.authors="Szymon Malecki"
LABEL org.opencontainers.image.source="https://github.com/szymon002/Movies-Store"
LABEL org.opencontainers.image.url="https://github.com/szymon002/Movies-Store"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0"

LABEL org.opencontainers.image.description="Movies store, movie module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:movie-store-movie
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

EXPOSE 8080

COPY target/movie-store-movie-${VERSION}.jar /opt/movie-store-movie/movie-store-movie.jar

CMD ["java", "-jar", "/opt/movie-store-movie/movie-store-movie.jar"]
