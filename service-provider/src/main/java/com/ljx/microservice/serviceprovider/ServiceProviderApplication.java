package com.ljx.microservice.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//在启动类上开启mapper扫描，就不用在每个mapper上单独使用@Mapper注解。注意一点要用tk包下的mapperscan
@MapperScan("com.ljx.microservice.serviceprovider.mapper")
public class ServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderApplication.class, args);
	}

}
