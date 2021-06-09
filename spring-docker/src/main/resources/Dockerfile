FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG finalName
ADD $finalName /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 7001


# deployments - deploying/ spawning of containers
# services - exposing deployments
# pods - group of containers
# nodes - number of kubernetes instances
# minikube - is the virtual environment setup for kubernetes
# kubectl - cli for kubernetes
# namespace - logical grouping of deployments
