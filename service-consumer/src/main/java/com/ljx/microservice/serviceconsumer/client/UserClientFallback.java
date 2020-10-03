package com.ljx.microservice.serviceconsumer.client;

import com.ljx.microservice.serviceconsumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author lijx
 * @date 2020/10/3 - 10:23
 * feign接口对应的熔断类，需要降级可以自定义此类，别忘了在配置文件中开启相关配置
 */
@Component
public class UserClientFallback implements UserClient {

    //此处的实现方法就像是对应接口方法的降级方法
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUserName("服务器繁忙，请稍后再试！");
        return user;
    }

}