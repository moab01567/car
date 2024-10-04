# Bruk en base image med Java (OpenJDK)
FROM openjdk:17-jdk-alpine

# Sett arbeidskatalogen inne i containeren
WORKDIR /app

# Kopier JAR-filen (som du bygger med Maven/Gradle) til /app-katalogen i containeren
COPY target/CarsBackend-0.0.1-SNAPSHOT.jar app.jar

# Eksponer porten som Spring Boot-applikasjonen lytter på (som standard er det 8080)
EXPOSE 8080

# Kommandoen for å starte Spring Boot-applikasjonen
ENTRYPOINT ["java", "-jar", "app.jar"]
