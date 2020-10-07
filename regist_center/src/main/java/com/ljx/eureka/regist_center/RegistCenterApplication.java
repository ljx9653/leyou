package com.ljx.eureka.regist_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//启用eureka服务端
@EnableEurekaServer
public class RegistCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistCenterApplication.class, args);
	}

}
