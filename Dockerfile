# # Docker multi-stage build

# # 1. Building the App with Maven
# FROM maven:3-jdk-11

# ADD . /ecommerce_staging

# WORKDIR /ecommerce_staging

# # Just echo so we can see, if everything is there
# RUN ls -l

# # Run Maven build
# RUN mvn clean install -DskipTests

# # 2. Just using the build artifact and then removing the build-container
# FROM openjdk:11-jdk


# RUN ls -l
# # Add Spring Boot authentication-service.jar to Container
# COPY --from=0  backend/ecommerce_staging/target/commerce-0.0.1-SNAPSHOT.jar ecommerce-0.0.1-SNAPSHOT.jar

# # Fire up our Spring Boot app by default
# # CMD ["sh", "-c", "java -Dserver.port=8080 -Xmx300m -Xss512k -XX:CICompilerCount=2 -Dfile.encoding=UTF-8 -XX:+UseContainerSupport  -Djava.security.egd=file:/dev/./urandom -jar ecommerce-0.0.1-SNAPSHOT.jar" ]

# ENTRYPOINT ["java", "-jar","ecommerce-0.0.1-SNAPSHOT.jar"]
# EXPOSE 8080
FROM openjdk:11-jdk
ADD target/ecommerce-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 8080