FROM openjdk:11-jdk

RUN echo ${DIR}

COPY ./docker-app /docker-app
WORKDIR /docker-app

CMD ["./gradlew", "bootRun"]