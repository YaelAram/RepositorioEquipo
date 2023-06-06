FROM openjdk:17.0-oracle
WORKDIR /api
COPY ./build/libs/diosesAPI-0.0.1-SNAPSHOT.jar /api/dockerGod.jar
ENTRYPOINT ["java", "-jar","dockerGod.jar"]