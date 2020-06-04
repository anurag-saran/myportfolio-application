FROM openjdk:8u131-jdk-alpine

MAINTAINER Anurag Saran "anurag.saran@gmail.com"

EXPOSE 8083

WORKDIR /usr/local/bin/

COPY target/stock-20.06.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar","app.jar"]
