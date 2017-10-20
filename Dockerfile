FROM openjdk:8-jdk-alpine
ARG JAR_FILE
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"
VOLUME /tmp
ADD target/${JAR_FILE}.jar app.jar
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]