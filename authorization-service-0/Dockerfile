FROM openjdk:11.0.3-jdk
WORKDIR usr/src
COPY ./target/authorization-service-0.0.1-SNAPSHOT.jar ./ 
ENTRYPOINT ["java","-jar","/authorization-service-0.0.1-SNAPSHOT.jar"]