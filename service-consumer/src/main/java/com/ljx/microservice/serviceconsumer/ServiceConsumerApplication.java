package com.ljx.microservice.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


//将服务消费方注册到eureka上
//注意：不要因为服务端使用了@EnableEurekaServer就以为客户端要使用@EnableEurekaClient注解,此注解由Netflix提供，虽然也可以用，但通常使用@EnableDiscoveryClient
//@EnableDiscoveryClient由springcloud提供，兼容性较好，推荐使用
/*@EnableDiscoveryClient
@SpringBootApplication
//开启Hystrix熔断器
@EnableCircuitBreaker*/
//组合注解，封装了@SpringBootApplication，@EnableDiscoveryClient，@EnableCircuitBreaker这三个注解
@SpringCloudApplication
// 开启feign客户端
@EnableFeignClients
public class ServiceConsumerApplication {

    /*我们使用了feign之后，无需自己注入RestTemplate*/
	//由于服务调用方需要一个能发送http请求的工具去调用服务，因此采用spring提供的RestTemplate
	//写在此处能保证所有类都可以使用这个RestTemplate
	@Bean
    //启用ribbon只需要添加此注解即可
    @LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

}
