package com.whahn.config;

import feign.Logger;
import feign.Request;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.text.MessageFormat.format;

// @Configuration
public class FeignConfig {

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100, 2000, 3);
    }

    @Bean
    ErrorDecoder decoder() {
        return new HttpErrorDecoder();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /*@Bean
    Decoder feignDecoder() {
        return new TestDecoder();
    }*/
}
