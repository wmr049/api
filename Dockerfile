FROM gradle:4.10.2-jdk8-alpine as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
COPY --from=builder /home/gradle/src/build/libs/api-gateway-0.1-all.jar api-gateway.jar
CMD java ${JAVA_OPTS} -jar api-gateway.jar
EXPOSE 8080