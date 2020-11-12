FROM openjdk:8-alpine

COPY target/uberjar/luhn-server.jar /luhn-server/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/luhn-server/app.jar"]
