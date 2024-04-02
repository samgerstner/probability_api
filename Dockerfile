FROM openjdk:21-jdk
LABEL org.opencontainers.image.authors="Sam.Gerstner@samgerstner.pro"
COPY target/ProbabilityApi-1.0.0.jar ProbabilityApi-1.0.0.jar
ENTRYPOINT ["java","-jar","/ProbabilityApi-1.0.0.jar"]