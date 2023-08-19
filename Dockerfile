#FROM openjdk:18
#VOLUME /tmp
#EXPOSE 8080
#ADD ./target/Canastica-0.0.1-SNAPSHOT.jar canastica.jar
#ENTRYPOINT ["java", "-jar", "/canastica.jar" ]

# Start with a base image containing Java runtime (AdoptOpenJDK)
FROM openjdk:18 AS build

# Set the working directory in the image to "/app"
WORKDIR /app

# Copy the Gradle executable to the image
COPY nvmw ./

# Copy the 'gradle' folder to the image
COPY nvm ./nvm

# Give permission to execute the gradle script
RUN chmod +x ./nvmw

# Copy the rest of the application source code
COPY . .

# Use Gradle to build the application
RUN sh ./nvmw build

# Set up a second stage, which will only keep the compiled application and not the build tools and source code
FROM openjdk:18

# Set the working directory to '/app'
WORKDIR /app

# Copy the jar file from the first stage
COPY --from=build /app/build/libs/*.jar app.jar

# Set the startup command to execute the jar
CMD ["java", "-jar", "/app/app.jar"]