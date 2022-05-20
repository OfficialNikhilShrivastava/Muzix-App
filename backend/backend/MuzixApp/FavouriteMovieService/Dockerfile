FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/favouritemovies_db
ADD ./target/FavouriteMovieService-0.0.1-SNAPSHOT.jar /usr/src/FavouriteMovieService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","FavouriteMovieService-0.0.1-SNAPSHOT.jar"]
