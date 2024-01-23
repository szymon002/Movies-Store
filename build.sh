function main() {
    cd ./movie-store-movie/; sh ./build.sh; cd ..
    cd ./movie-store-studio/; sh ./build.sh; cd ..
    cd ./gateway/; sh ./build.sh; cd ..
    cd ./movie-store-ng/; sh ./build.sh; cd ..
}

main "$@"
