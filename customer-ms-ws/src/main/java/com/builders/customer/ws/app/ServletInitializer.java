package com.builders.customer.ws.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


public class ServletInitializer extends SpringBootServletInitializer   {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        return application.sources(CustomerApplication.class);
    }
}
