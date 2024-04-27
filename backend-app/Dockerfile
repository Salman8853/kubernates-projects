# Use the official OpenJDK 11 image as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/backend-app.jar /app/backend-app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8000

# Run the JAR file when the container launches
CMD ["java", "-jar", "backend-app.jar"]
