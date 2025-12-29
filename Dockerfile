# Etapa 1: Compilación con Maven
FROM maven:3.8.8-eclipse-temurin-8 AS build

WORKDIR /app

# Copiar archivos de configuración de Maven primero (para aprovechar caché de Docker)
COPY pom.xml .

# Descargar dependencias (esto se cachea si pom.xml no cambia)
RUN mvn dependency:go-offline -B

# Copiar todo el código fuente
COPY src ./src

# Compilar el proyecto
ARG SENTRY_AUTH_TOKEN
ENV SENTRY_AUTH_TOKEN="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"
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final ligera
FROM eclipse-temurin:8-jre-ubi9-minimal

WORKDIR /app

# Copiar el JAR compilado de la etapa anterior
COPY --from=build /app/target/swagger-spring-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-javaagent:sentry-opentelemetry-agent-8.28.0.jar", "-jar", "app.jar" ]