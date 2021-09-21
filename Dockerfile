FROM openjdk:8
ARG JAR_FILE=target/docker-spring-boot.jar
ADD ${JAR_FILE} docker-spring-boot.jar
ENTRYPOINT ["java","-jar","/app.jar"]