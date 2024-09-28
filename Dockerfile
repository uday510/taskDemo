FROM openjdk:17-jdk-slim as build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=build /app/target/task-management-0.0.1-SNAPSHOT.jar task-management.jar

ENTRYPOINT ["java", "-jar", "task-management.jar"]
