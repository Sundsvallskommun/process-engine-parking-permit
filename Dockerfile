FROM maven:3.8.3-openjdk-17 AS build
COPY /jenkins/workspace/Parking_Permit_Staging/src /usr/src/app/src
COPY /jenkins/workspace/Parking_Permit_Staging/pom.xml /usr/src/app
COPY /.m2/settings.xml /root/.m2/settings.xml
WORKDIR /usr/src/app
RUN cat /root/.m2/settings.xml
#These are only used so the tests that gets run in mvn package can resolve the placeholders
ARG CAMUNDA_ENDPOINT
ARG CAMUNDA_REST_URL
ARG OAUTH2_TOKEN_URL
ARG CASEDATA_ERRANDS_URL
ARG CITIZEN_URL
ARG OAUTH2_CLIENT_KEY
ARG OAUTH2_CLIENT_SECRET

RUN mvn clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /usr/src/app/target/parkingpermit.jar parkingpermit.jar
ENTRYPOINT ["java","-jar","/parkingpermit.jar"]