package com.demolambda;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ResourceConfig {
    @Bean("messageSource")
    public MessageSource  getMessageSource(){
        ReloadableResourceBundleMessageSource rc = new ReloadableResourceBundleMessageSource();
        rc.setDefaultEncoding("utf-8");
        rc.setBasenames("classpath:/MEssage/menu");
        return rc ;
    }
}
