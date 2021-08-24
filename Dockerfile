FROM openjdk:8
EXPOSE 8080
ADD target/jumia-exercise-api.jar jumia-exercise-api.jar
ENTRYPOINT ["java","-jar","/jumia-exercise-api.jar"]