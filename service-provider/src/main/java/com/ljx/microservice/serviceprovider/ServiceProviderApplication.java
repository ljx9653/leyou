package com.ljx.microservice.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//在启动类上开启mapper扫描，就不用在每个mapper上单独使用@Mapper注解。注意一点要用tk包下的mapperscan
@MapperScan("com.ljx.microservice.serviceprovider.mapper")
//将服务提供方注册到eureka上
//注意：不要因为服务端使用了@EnableEurekaServer就以为客户端要使用@EnableEurekaClient注解,此注解由Netflix提供，虽然也可以用，但通常使用@EnableDiscoveryClient
//@EnableDiscoveryClient由springcloud提供，兼容性较好，推荐使用
@EnableDiscoveryClient
public class ServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderApplication.class, args);
	}

}
