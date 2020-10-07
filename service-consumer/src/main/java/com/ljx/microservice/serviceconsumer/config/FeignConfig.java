package com.ljx.microservice.serviceconsumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijx
 * @date 2020/10/3 - 10:44
 *  自定义feign日志级别的配置类
 */
@Configuration
public class FeignConfig{

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}