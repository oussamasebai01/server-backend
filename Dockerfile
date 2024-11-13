# Utiliser une image de base Java
FROM openjdk:11
EXPOSE 8002
ADD target/server-0.0.1-SNAPSHOT.jar   server.jar
ENTRYPOINT ["java","-jar","/server.jar"]