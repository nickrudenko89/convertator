FROM openjdk:8-jdk-alpine
FROM ubuntu

# Set timezone
ENV TZ=Europe/Kiev
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Specify the mount point for external data inside the container
VOLUME /tmp

# External port, which our application will be accessible from the outside
EXPOSE 8080

# Install git
RUN apt-get update        
RUN apt-get install -y git

RUN cd /tmp/

#Clone
RUN git clone https://github.com/nickrudenko89/convertator.git

RUN find /convertator/ -type d -exec chmod 777 {} \;

RUN cd convertator

# Install Maven
RUN apt-get install -y maven

# Set working directory
WORKDIR /convertator/

# Make Maven build
RUN mvn clean
RUN mvn install

# Path to jar
ARG JAR_FILE=target/convertator-0.0.1.jar

# Add jar with name convertator-0.0.1.jar to image
ADD ${JAR_FILE} convertator-0.0.1.jar

# Run jar
ENTRYPOINT ["java","-jar","/convertator/convertator-0.0.1.jar"]