FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/api-gateway-*.jar api-gateway.jar

EXPOSE 8080

CMD ["java", "-jar", "api-gateway.jar"]
