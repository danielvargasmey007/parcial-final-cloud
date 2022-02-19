# our base build image
FROM maven:3.6.3-openjdk-14 as build

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# set dependency directory
ARG DEPENDENCY=target/dependency

# build for release
RUN mvn -Dhttps.protocols=TLSv1.2 -DskipTests package
RUN mkdir -p ${DEPENDENCY} && (cd ${DEPENDENCY}; jar -xf ../*.jar)

# our final base image
FROM openjdk:14-jdk-alpine

#set microservice directory name
ENV MICROSERVICE_NAME=booking

# create user for access to logs
RUN addgroup -S tdm && adduser -S tdm -G tdm
RUN mkdir -p /${MICROSERVICE_NAME}/logs
RUN chown -R tdm /${MICROSERVICE_NAME}
USER tdm

# set deployment directory
WORKDIR /${MICROSERVICE_NAME}

# set dependency directory
ARG DEPENDENCY=target/dependency

# copy artifacts
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib ./lib
COPY --from=build ${DEPENDENCY}/META-INF ./META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes ./

ENTRYPOINT ["java", "-cp", ".:lib/*", "com.cloud.bookings.BookingsApplication"]