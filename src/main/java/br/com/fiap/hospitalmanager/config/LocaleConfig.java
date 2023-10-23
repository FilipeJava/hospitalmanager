package br.com.fiap.hospitalmanager.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;



@Configuration
public class LocaleConfig {
    //Message Source

    @Bean
    MessageSource messageSource(){
         var messageSource = new ResourceBundleMessageSource();
         messageSource.setBasename("lang/messages");
         messageSource.setDefaultEncoding("UTF-8");
         return messageSource;
    }

}
