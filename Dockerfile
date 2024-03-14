# Use an official Maven runtime as a parent image
FROM maven:3.8.4-openjdk-11-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project file
COPY pom.xml .

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package

# Create a new image based on OpenJDK 11
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the build stage to the new image
COPY --from=build /app/target/*.jar ./app.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]