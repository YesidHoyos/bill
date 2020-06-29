FROM openjdk:8-jre-alpine
RUN mkdir -p /usr/src/apps/bill
COPY target/bill-0.0.1-SNAPSHOT.jar /usr/src/apps/bill
WORKDIR /usr/src/apps/bill
CMD ["nohup", "java", "-jar", "bill-0.0.1-SNAPSHOT.jar", "&"]