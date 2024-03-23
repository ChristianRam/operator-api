FROM gradle:8.6.0-jdk11 AS build
WORKDIR /app
COPY build.gradle .
COPY src ./src
RUN gradle clean build

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./operator.jar
EXPOSE 8080
CMD ["java","-jar","operator.jar"]