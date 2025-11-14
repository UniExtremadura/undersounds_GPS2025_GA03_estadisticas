FROM eclipse-temurin:8-jdk-ubi9-minimal

WORKDIR /app

COPY target/swagger-spring-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]