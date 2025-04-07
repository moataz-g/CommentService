FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/comments-service-*.jar comments-service.jar

EXPOSE 8089

CMD ["java", "-jar", "comments-service.jar"]
