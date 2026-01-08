FROM gradle:8.7-jdk17 AS build
WORKDIR /account

COPY build.gradle.kts settings.gradle.kts ./
COPY gradle ./gradle
COPY src ./src

RUN gradle clean build --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /account

COPY --from=build /account/build/libs/account.jar account.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "account.jar"]