FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="gateway"
LABEL org.opencontainers.image.authors="Szymon Malecki"
LABEL org.opencontainers.image.source="https://github.com/szymon002/Movies-Store"
LABEL org.opencontainers.image.url="https://github.com/szymon002/Movies-Store"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.description="Movies store, gateway module."
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV MOVIESTORE_GATEWAY_HOST=localhost:8080
ENV MOVIESTORE_MOVIE_URL=http://localhost:8081
ENV MOVIESTORE_STUDIO_URL=http://localhost:8082

EXPOSE 8080

COPY target/gateway-${VERSION}.jar /opt/gateway/gateway.jar

CMD ["java", "-jar", "/opt/gateway/gateway.jar"]
