FROM openjdk:17-jdk

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

RUN ./mvnw dependency:go-offline

RUN ./mvnw test

CMD ["./mvnw", "spring-boot:run"]