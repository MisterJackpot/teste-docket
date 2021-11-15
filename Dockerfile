FROM openjdk:8-jdk-alpine
RUN mkdir /app
WORKDIR /app
COPY build/libs/cartorio-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-jar","app.jar"]