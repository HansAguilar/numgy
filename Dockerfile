## Use an OpenJDK 8 runtime as the base image
#FROM openjdk:8-jdk-alpine
#
## Set the working directory in the container
#WORKDIR /app
#
## Copy the packaged Spring Boot application JAR file into the container
#COPY build/libs/numgy-server-1.0-SNAPSHOT.jar /app
#
## Expose the port that your Spring Boot application runs on
#EXPOSE 8080
#
## Specify the command to run your Spring Boot application when the container starts
#CMD ["java", "-jar", "numgy-server-1.0-SNAPSHOT.jar"]

#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:8-jdk-alpine

# Set working directory (adjust if your Gradle files are elsewhere)
WORKDIR /app

# Copy Gradle build script (if not already in the context)
COPY build.gradle ./

# Run Gradle build to generate JAR file
RUN ./gradlew build

# Copy the generated JAR file
COPY build/libs/*.jar app.jar

# Executable directive (optional, depends on your application)
ENTRYPOINT ["java", "-jar", "app.jar"]
