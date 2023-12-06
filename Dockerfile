## Build Stage
FROM maven:3-eclipse-temurin-21 AS builder 

LABEL MAINTAINER="tysonchan17@gmail.com"
LABEL APPLICATION="healthcheck application"

# working and target directory or app will be in
WORKDIR /app

# copy all the required to /app
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

# build the app
RUN mvn package -Dmaven.text.skip=true


## Publish stage
FROM openjdk:21-jdk

ARG APP_DIR2=/tai17
WORKDIR ${APP_DIR2}

COPY --from=builder /app/target/day18-0.0.1-SNAPSHOT.jar healthcheck.jar

ENTRYPOINT ["java", "-jar", "healthcheck.jar"]

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=5s --retries=3 \
    CMD curl -s -f http://localhost:${PORT}/demo/healthz || exit 1
