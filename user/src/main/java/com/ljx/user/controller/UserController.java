package com.ljx.user.controller;

import com.ljx.user.pojo.User;
import com.ljx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lijx
 * @date 2019/12/3 - 10:23
 */

@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ResponseBody
    //这里使用{}代表id是一个变量
    @GetMapping("{id}")
    //@PathVariable用于接收请求url中的参数，而@RequestParam用于接收请求报文的requestbody中的参数
    public User queryUserById(@PathVariable("id")long id){
        return userService.queryUserById(id);
    }

    @GetMapping("test")
    @ResponseBody
    public String test(){
        return "hello test";
    }
}
