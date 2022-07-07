FROM maven:3.8.3-openjdk-17 AS build
COPY /jenkins/workspace/Parking_Permit_Staging/src /usr/src/app/src
COPY /jenkins/workspace/Parking_Permit_Staging/pom.xml /usr/src/app
COPY /.m2/settings.xml /root/.m2/settings.xml
WORKDIR /usr/src/app
RUN cat /root/.m2/settings.xml
RUN mvn clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /usr/src/app/target/parkingpermit.jar parkingpermit.jar
ENTRYPOINT ["java","-jar","/parkingpermit.jar"]