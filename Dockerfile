# Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app
COPY ST_DB/ .

RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Environment variables (optional defaults)
ENV DB_URL="jdbc:postgresql://dpg-d6o42q7kijhs73edqd00-a.oregon-postgres.render.com:5432/st_db_zalp"
ENV DB_USERNAME="st_db_zalp_user"
ENV DB_PASSWORD="8SJb8rJWyhJzNvaa2PG0TAXSa2OW7ZRB"

ENTRYPOINT ["java","-jar","app.jar"]