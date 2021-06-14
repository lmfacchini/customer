From tomcat:9-jdk11-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./customer-ms-ws/target/customer_v1.war /usr/local/tomcat/webapps/customer_v1.war
CMD ["catalina.sh","run"]