FROM openjdk:18
VOLUME /tmp
EXPOSE 8080
ADD ./target/Canastica-0.0.1-SNAPSHOT.jar canastica.jar
ENTRYPOINT ["java", "-jar", "/canastica.jar" ]