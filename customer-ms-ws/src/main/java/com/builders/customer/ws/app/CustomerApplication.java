package com.builders.customer.ws.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.builders.customer")
@SpringBootApplication
public class CustomerApplication  {


    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }




}
