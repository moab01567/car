#using image node
FROM node:22-alpine3.19 AS frontend-build
#adding a frontend directory in container
WORKDIR /frontend
#copying all files in my local Frontend Directory to the docker image WORKDIR /frontend
COPY ./Frontend ./
#importing stuff
RUN npm install
#buliding the html,css ans js files
RUN npm run build

# Bruk en base image med Java (OpenJDK)
FROM openjdk:17-jdk-alpine AS backend-build

# adding a backend directory in container
WORKDIR /backend

# Kopier JAR-filen (som du bygger med Maven/Gradle) til /app-katalogen i containeren
COPY ./CarsBackend ./

COPY --from=frontend-build /frontend/dist /backend/src/main/resources/static

RUN apk update && \
    apk add --no-cache dos2unix && \
    dos2unix mvnw && \
    chmod +x mvnw

RUN ./mvnw clean install

#COPY /backend/target/**.jar app.jar
RUN cp /backend/target/*.jar /backend/app.jar

# Kommandoen for å starte Spring Boot-applikasjonen
ENTRYPOINT ["java", "-jar", "app.jar"]
