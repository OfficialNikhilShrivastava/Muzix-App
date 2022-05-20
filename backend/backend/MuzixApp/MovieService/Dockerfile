FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/movies_db
ADD ./target/MovieService-0.0.1-SNAPSHOT.jar /usr/src/MovieService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","MovieService-0.0.1-SNAPSHOT.jar"]
