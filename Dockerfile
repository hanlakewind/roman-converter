FROM openjdk:8-jdk-alpine

ENV GIT_DOWNLOAD_URL https://github.com/hanlakewind/roman-converter/archive/master.zip

RUN apk add --update \
        curl \
        unzip; \
    cd /root; \
    curl -o roman-converter.zip -fsSL ${GIT_DOWNLOAD_URL}; \
    unzip roman-converter.zip; \
    rm -f roman-converter.zip; \
    cd roman-converter-master; \
    ./mvnw clean install

ENTRYPOINT ["java", "-jar", "/root/roman-converter-master/target/roman-converter-1.0.0.jar"]
