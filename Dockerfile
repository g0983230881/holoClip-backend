# Stage 1: Build the application using Maven
# This stage uses a Maven image to build the .war file from source code
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lightweight runtime image
# This stage starts from a clean Tomcat image and copies the .war file from the 'build' stage
FROM tomcat:9.0-jdk17-corretto
ARG WAR_FILE=/app/target/*.war
COPY --from=build ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]