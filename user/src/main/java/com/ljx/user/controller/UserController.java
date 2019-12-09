package com.ljx.user.controller;

import com.ljx.user.pojo.User;
import com.ljx.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lijx
 * @date 2019/12/3 - 10:23
 */

@RequestMapping("user")
@Controller
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

    @GetMapping("/all")
    public String all(ModelMap model) {
        // 查询用户
        List<User> users = this.userService.queryAll();
        // 放入模型
        model.addAttribute("users", users);
        // 返回模板名称（就是classpath:/templates/目录下的html文件名）
        return "users";
    }
}
