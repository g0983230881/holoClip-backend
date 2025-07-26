# Stage 1: Build the application
# Use an official Maven image to build the project.
# Specify the Java version that matches your project (17).
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project definition file
COPY pom.xml .

# Download all dependencies. This is done as a separate step to leverage Docker's layer caching.
# If pom.xml doesn't change, this layer won't be re-executed.
RUN mvn dependency:go-offline

# Copy the rest of your application's source code
COPY src ./src

# Package the application into a WAR file.
# The -DskipTests flag is used to speed up the build process by skipping tests.
RUN mvn package -DskipTests

# Stage 2: Create the final, smaller image
# Use an official Tomcat image which is a servlet container to run the WAR file.
# Use a version that is compatible with Java 17.
FROM tomcat:9.0-jdk17-corretto

# The application's WAR file will be in the target directory.
# Copy it from the 'build' stage to Tomcat's webapps directory.
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port that Tomcat runs on by default.
# Your application.properties also specifies 8080.
EXPOSE 8080

# This command will start the Tomcat server when the container launches.
CMD ["catalina.sh", "run"]