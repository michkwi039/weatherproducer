FROM openjdk:11
ADD target/producer.jar producer.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "producer.jar"]