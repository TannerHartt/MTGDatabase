FROM openjdk
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY ./build/libs/mtgdex-1.0-SNAPSHOT-all.jar mtgdex.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar mtgdex.jar

