# Utilise une image OpenJDK
FROM openjdk:17-jdk-slim

# Répertoire de travail
WORKDIR /app

# Copie le jar construit avec Maven
COPY target/comments-service-*.jar app.jar

# Expose le port
EXPOSE 8089

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]
