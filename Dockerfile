 # Use an official OpenJDK runtime as base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container (Ensure your JAR file name matches)
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8089

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
