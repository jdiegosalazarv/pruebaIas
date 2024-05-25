FROM openjdk:17
COPY build/libs/pruebaIas-0.0.1-SNAPSHOT.jar ias-app.jar
ENTRYPOINT ["java", "-jar", "ias-app.jar"]