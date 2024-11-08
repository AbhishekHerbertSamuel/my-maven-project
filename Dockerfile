# Use an official Maven image with OpenJDK 17 as the base image
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file and download dependencies to speed up subsequent builds
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire application source code to the container
COPY src ./src

# Run the Maven build (clean, test, package)
RUN mvn clean package

# Use a lightweight OpenJDK image for the final container
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the previous stage
COPY --from=build /app/target/my-maven-project-1.0-SNAPSHOT.jar app.jar

# Expose the port your application will run on
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "app.jar"]
