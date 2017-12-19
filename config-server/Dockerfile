FROM openjdk:8u151-alpine

COPY target/config-server.jar /app/

HEALTHCHECK CMD wget --spider http://localhost:8888/health
EXPOSE 8888

CMD ["java", "-jar", "/app/config-server.jar"]
