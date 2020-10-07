package com.ljx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *  引导类：springboot应用的入口
 */
//启用springboot应用的自动配置，引导类必备注解
@EnableAutoConfiguration
//组件扫描，默认扫描该类所在的包以及它的子孙包，类似于<context:component-scan base-packege="">
@ComponentScan
//组合注解，相当于 @EnableAutoConfiguration @ComponentScan @SpringBootConfiguration的组合
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
