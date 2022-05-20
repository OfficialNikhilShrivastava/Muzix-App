FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/SpringCloudAPIGateway-0.0.1-SNAPSHOT.jar /usr/src/SpringCloudAPIGateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","SpringCloudAPIGateway-0.0.1-SNAPSHOT.jar"]
