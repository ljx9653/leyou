package com.ljx.microservice.serviceconsumer.controller;

import com.ljx.microservice.serviceconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijx
 * @date 2019/12/19 - 14:46
 */
@RestController
@RequestMapping("consumer/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public User queryUserById(@RequestParam("id") Long id){
        User user = this.restTemplate.getForObject("http://localhost:8081/user/" + id, User.class);
        return user;
    }
}
