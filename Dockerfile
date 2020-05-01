FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9092
ADD ./build/libs/rating-spring-boot-docker-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]