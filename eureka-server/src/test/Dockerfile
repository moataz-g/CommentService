# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built JAR file into the container
COPY target/eureka-server-*.jar eureka-server.jar

# Expose the port for Eureka
EXPOSE 8761

# Run the application
CMD ["java", "-jar", "eureka-server.jar"]
