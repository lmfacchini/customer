package com.stinen.message.ws.app;

import nom.springbased.web.AbstractConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages="com.stinen.message.core.repository")
@EnableConfigurationProperties
@EnableCaching
public class MessageMicroservicesConfiguration extends AbstractConfiguration {

    public MessageMicroservicesConfiguration() {
        super(MessageMicroservicesApplication.APPLICATION_NAME);
    }




}
