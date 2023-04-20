FROM openjdk:17.0.2-jdk-slim
VOLUME /tmp
COPY /target/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]