# Stage 1: Build the JAR
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY --from=build /app/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
