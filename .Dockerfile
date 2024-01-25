FROM amazoncorretto:21.0.1-alpine3.18

COPY target/orders-1.0.jar orders.jar

ENTRYPOINT ["java","-jar", "/app.jar"]