package com.ljx.microservice.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServiceConsumerApplication {

	//由于服务调用方需要一个能发送http请求的工具去调用服务，因此采用spring提供的RestTemplate
	//写在此处能保证所有类都可以使用这个RestTemplate
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

}
