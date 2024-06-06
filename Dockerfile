# Use an OpenJDK 8 runtime as the base image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY build/libs/numgy-server-1.0-SNAPSHOT.jar /app

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "numgy-server-1.0-SNAPSHOT.jar"]
