FROM openjdk:17
COPY ./target/sample-micronaut-applications-*.jar app.jar
EXPOSE 8100
ENTRYPOINT ["java","-cp","app.jar","pl.piomin.services.main.MainApp"]
