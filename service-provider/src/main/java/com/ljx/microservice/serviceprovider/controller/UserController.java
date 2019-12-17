package com.ljx.microservice.serviceprovider.controller;

import com.ljx.microservice.serviceprovider.pojo.User;
import com.ljx.microservice.serviceprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijx
 *
 */

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //这里使用{}代表id是一个变量
    @GetMapping("{id}")
    //@PathVariable用于接收请求url中的参数，而@RequestParam用于接收请求报文的requestbody中的参数
    public User queryUserById(@PathVariable("id")long id){
        return this.userService.queryUserById(id);
    }

}
