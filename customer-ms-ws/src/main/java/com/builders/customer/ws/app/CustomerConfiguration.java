package com.builders.customer.ws.app;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages="com.builders.customer.core.repository")
@ComponentScan("com.builders.customer")
@Configuration
@EnableAutoConfiguration
public class CustomerConfiguration {


}
