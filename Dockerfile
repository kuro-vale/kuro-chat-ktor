FROM gradle:7.5.1-jdk17-alpine AS builder

WORKDIR /home/gradle/src
COPY . .
RUN gradle buildFatJar --no-daemon

FROM eclipse-temurin:17-alpine

EXPOSE 8080

RUN mkdir /app
COPY --from=builder /home/gradle/src/build/libs/*.jar /app/ktor-chat.jar
ENTRYPOINT ["java","-jar","/app/ktor-chat.jar"]