package com.stinen.message.ws.app;

import nom.springbased.web.AbstractApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"nom.framework.springbased.microservice.app", "com.stinen.message"})
@SpringBootApplication
public class MessageMicroservicesApplication extends AbstractApplication {


    public final static String APPLICATION_NAME = "message_v1";

    public MessageMicroservicesApplication() {
        super(APPLICATION_NAME);
    }


    public static void main(String[] args) {
        run(MessageMicroservicesApplication.class, args);
    }


}
