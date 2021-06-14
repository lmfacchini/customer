From jetty:11.0.4-jre11
RUN rm -rf /var/lib/jetty/webapps/*
COPY ./customer-ms-ws/target/customer_v1.war /var/lib/jetty/webapps/customer_v1.war
RUN $JETTY_HOME/bin/jetty.sh start