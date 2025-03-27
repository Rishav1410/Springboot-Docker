# ========== Stage 1: Build the application ==========
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy all files to the container
COPY . .

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# ========== Stage 2: Run the application ==========
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
