FROM docker.io/eclipse-temurin:21-jdk

WORKDIR /app

COPY target/quarkus-app/ /app/quarkus-app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/quarkus-app/quarkus-run.jar"]
