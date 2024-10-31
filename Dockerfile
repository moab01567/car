# Bruk en base image med Java (OpenJDK)
FROM openjdk:17-jdk-alpine AS backend-build

# adding a backend directory in container
WORKDIR /backend

# Kopier JAR-filen (som du bygger med Maven/Gradle) til /app-katalogen i containeren
COPY ./CarsBackend ./

RUN apk update && \
    apk add --no-cache dos2unix && \
    dos2unix mvnw && \
    chmod +x mvnw

RUN ./mvnw clean install

#COPY /backend/target/**.jar app.jar
RUN cp /backend/target/*.jar /backend/app.jar

# Kommandoen for å starte Spring Boot-applikasjonen
ENTRYPOINT ["java", "-jar", "app.jar"]
