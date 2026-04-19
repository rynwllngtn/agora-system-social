FROM maven:3.9.14-eclipse-temurin-25-alpine AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests



FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar agora-social-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "agora-social-api.jar"]