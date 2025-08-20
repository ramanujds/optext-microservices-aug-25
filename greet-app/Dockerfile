FROM openjdk:26-slim
WORKDIR /app
ADD target/*.jar app.jar
CMD ["java","-jar","app.jar"]
EXPOSE 8080