package com.camp.camping;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class WebConfig implements ApplicationContextAware {

    ApplicationContext context;

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.context = context;
    }
}