FROM openjdk:8

ENV JAVA_OPTS=""

COPY target/*.jar /app.jar

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.datasource.url=\"$DB_JDBCURL\" -Dspring.datasource.username=\"$DB_USERNAME\" -Dspring.datasource.password=\"$DB_PASSWORD\" -jar /app.jar" ]
