FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/Tasks-0.0.1-SNAPSHOT.jar /app/Tasks.jar
EXPOSE 8080
ENTRYPOINT ["java","-DDB_URL=jdbc:mysql://mariadb_server:3306/tasks", "-jar", "Tasks.jar"]