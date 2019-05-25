FROM openjdk:8-jre-slim
COPY ./app.jar app/app.jar
COPY ./application.yml /app/app.yml
CMD ["java","-jar","/app/app.jar","--spring.config.location=/app/app.yml"]
