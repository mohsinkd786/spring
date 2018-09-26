FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG finalName
ADD $finalName /app.jar
ENTRYPOINT ["java","-jar","/app.jar","--server.port=8080"]
EXPOSE 8080