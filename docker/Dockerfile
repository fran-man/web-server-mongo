FROM java:8

WORKDIR /webapp

COPY basic-webapp-exec-1.0-SNAPSHOT-war-exec.jar /webapp

EXPOSE 9292

CMD ["java", "-jar", "basic-webapp-exec-1.0-SNAPSHOT-war-exec.jar", "-httpPort", "9292"]
