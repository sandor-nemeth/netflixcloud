FROM openjdk:8u151-alpine

COPY target/book-rating-aggregator.jar /app/

HEALTHCHECK CMD wget --spider http://localhost:8080/health
EXPOSE 8080

CMD ["java", "-jar", "/app/book-rating-aggregator.jar"]
