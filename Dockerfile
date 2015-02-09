###########################
#Docker container for Docker Cgroup Manager
#Downloads and compiles sources
#Diverse Team INRIA Rennes
###########################

# Pull base image.
FROM dockerfile/ubuntu
MAINTAINER Aymeric Hervieu <aymeric.hervieu@inria.fr>
# Install Java.
RUN \
echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
add-apt-repository -y ppa:webupd8team/java && \
apt-get update && \
apt-get install -y oracle-java8-installer && \
rm -rf /var/lib/apt/lists/* && \
rm -rf /var/cache/oracle-jdk8-installer

# Install Maven.
RUN apt-get update
RUN  apt-get install -y wget git maven
# Define working directory.
WORKDIR /data

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
RUN git config --global http.postBuffer 524288000
RUN git clone https://github.com/ahervieu/docker-manager.git
WORKDIR docker-manager
RUN mvn clean install
WORKDIR org.kevoree.docker.containerDriver.rest
RUN pwd
RUN mvn clean compile assembly:single
WORKDIR target
EXPOSE 4848 8081 8181
CMD jar -jar docker-container-rest-*.jar