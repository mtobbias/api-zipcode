FROM openjdk:11.0-slim
MAINTAINER https://github.com/mtobbias
COPY target/api-zipcode-0.0.1-SNAPSHOT.jar api-zipcode.jar
ENTRYPOINT ["java", "-jar", "/api-zipcode.jar"]