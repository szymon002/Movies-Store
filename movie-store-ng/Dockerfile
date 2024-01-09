FROM nginx:1.23.3

LABEL org.opencontainers.image.title="movies-store-ng"
LABEL org.opencontainers.image.authors="Szymon Malecki"
LABEL org.opencontainers.image.source="https://github.com/szymon002/Movies-Store"
LABEL org.opencontainers.image.url="https://github.com/szymon002/Movies-Store"
LABEL org.opencontainers.image.version="1.0.0"
LABEL org.opencontainers.image.description="MovieStore frontend"
LABEL org.opencontainers.image.licenses="MIT"

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/movie-store-ng /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
