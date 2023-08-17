FROM eclipse-temurin:17 AS build
LABEL maintainer="danez7000@gmail.com"
WORKDIR /app
COPY . /app


RUN apt-get update && apt-get install -y maven


RUN mvn clean package

FROM eclipse-temurin:17
WORKDIR /app
COPY --from=build /app/target/BFF-0.0.4-SNAPSHOT.jar /app/test-docker.jar


ENTRYPOINT ["java", "-jar", "test-docker.jar"]