FROM maven:3.8.3-openjdk-17 AS build
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app
WORKDIR /usr/src/app
RUN --mount=type=secret,id=mvnsettings,required=true,target=/root/.m2/settings.xml cat /root/.m2/settings.xml

FROM openjdk:17-jdk-alpine
COPY --from=build /usr/src/app/target/parkingpermit.jar parkingpermit.jar
ENTRYPOINT ["java","-jar","/parkingpermit.jar"]