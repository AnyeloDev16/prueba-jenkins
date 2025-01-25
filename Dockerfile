FROM openjdk:21-jdk-slim

EXPOSE 8080

WORKDIR /app

# Copiar y pegar archivos dentro del contenedor
COPY ./pom.xml /app
COPY ./.mvn /app/.mvn
COPY ./mvnw /app

# Descargar las dependencias
RUN ./mvnw dependency:go-offline

# Copiar el codigo fuente dentro del contenedor
COPY ./src /app/src

# Construir nuestra app
RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["java", "-jar", "/app/target/prueba-docker-0.0.1-SNAPSHOT.jar"]