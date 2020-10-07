package com.ljx.microservice.serviceconsumer.controller;

import com.ljx.microservice.serviceconsumer.client.UserClient;
import com.ljx.microservice.serviceconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijx
 * @date 2020/10/3 - 10:21
 */
@RestController
@RequestMapping("consumer/feign/user")
public class FeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    public User queryUserById(@RequestParam("id") Long id){
        User user = this.userClient.queryUserById(id);
        return user;
    }
}
