FROM frolvlad/alpine-oraclejdk8:slim
ADD ["build/libs/jcart-backoffice-service-1.0.0-SNAPSHOT.jar", "app.jar"]
EXPOSE 8080 8787
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n -jar /app.jar" ]
