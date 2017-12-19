FROM openjdk:8u151-alpine

COPY target/zipkin-app.jar /app/

HEALTHCHECK CMD wget --spider http://localhost:8080/health

CMD ["java", "-jar", "/app/zipkin-app.jar"]
