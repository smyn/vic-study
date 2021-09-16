FROM harbor.newegg.org/base/openjdk:11-jdk-alpine
VOLUME /tmp
ENV TZ=America/Los_Angeles
COPY docker/ ./
RUN sed -i 's/\r//' start.sh && chmod +x start.sh

COPY target/classes/templates/ ./templates/

COPY target/*.jar app.jar

ENTRYPOINT ["sh","start.sh"]