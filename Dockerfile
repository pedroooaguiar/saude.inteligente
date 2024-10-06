FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/saudeinteligente-0.0.1-SNAPSHOT.jar /app/saudeinteligente.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "echo 'Waiting for Oracle DB to be ready...' && sleep 60 && java -jar /app/saudeinteligente.jar"]
