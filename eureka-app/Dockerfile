FROM openjdk:8u151-alpine

COPY target/eureka-app.jar /app/

HEALTHCHECK CMD wget --spider http://localhost:8761/health

CMD ["java", "-jar", "/app/eureka-app.jar"]
