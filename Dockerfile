FROM gradle:8.7-jdk17 AS build
WORKDIR /home/gradle/project

COPY settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle

COPY app ./app
COPY commons ./commons
COPY account ./account
COPY transaction ./transaction

RUN gradle :app:clean :app:bootJar --no-daemon -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /home/gradle/project/app/build/libs/app.jar pismo-app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pismo-app.jar"]