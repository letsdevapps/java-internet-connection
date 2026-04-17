FROM maven:latest

WORKDIR /app

# Instala o ping pois a imagem Maven vem minimalista sem ele
RUN apt-get update && apt-get install -y iputils-ping

COPY pom.xml .
COPY src /app/src

RUN mvn clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/java-internet-connection-1.0-SNAPSHOT.jar"]