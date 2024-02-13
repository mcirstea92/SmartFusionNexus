# Start with a Maven image
FROM maven:3.9.6-eclipse-temurin-17 AS build
# Set working directory
WORKDIR /app
# Copy the Quarkus application source code into the Docker image
RUN echo creating dir && mkdir -p qhub-jpa && pwd && ls
COPY qhub-jpa .
COPY qhub-models .
COPY rest .
COPY pom.xml .
# Build the Quarkus application
CMD mvn -DskipTests clean install
#
## Set up the runtime environment
#FROM eclipse-temurin:17
### Set the working directory
#WORKDIR /app
## Copy the built Quarkus application from the build stage
#COPY --from=build /app/target/*-runner.jar ./application.jar
#RUN ls && pwd
## Expose the port your Quarkus application listens on
#EXPOSE 8082
## Run the Quarkus application
#CMD ["java", "-jar", "application.jar"]
