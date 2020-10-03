package com.ljx.microservice.serviceconsumer.client;

import com.ljx.microservice.serviceconsumer.config.FeignConfig;
import com.ljx.microservice.serviceconsumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lijx
 * @date 2020/10/3 - 10:22
 * feign接口
 */
//指定微服务名，熔断类，配置类
@FeignClient(value = "service-provider", fallback = UserClientFallback.class, configuration = FeignConfig.class)
//不建议在这里使用@RequestMapping注解，可能会引发bug
//@RequestMapping("consumer/user")
public interface UserClient {

    @GetMapping("user/{id}")
    User queryUserById(@PathVariable("id") Long id);

}
