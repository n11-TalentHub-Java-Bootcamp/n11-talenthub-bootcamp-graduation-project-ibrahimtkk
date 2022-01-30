FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
ADD build/libs/application-0.0.1-SNAPSHOT.jar application-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/application-0.0.1-SNAPSHOT.jar"]