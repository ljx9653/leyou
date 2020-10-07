package com.ljx.springboot.controller;

/**
 * @author lijx
 * @date 2019/11/18 - 10:29
 */

import com.ljx.springboot.configuration.springConfiguration.JdbcConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
//将一个普通类作为springboot启动类时，必须要加上此注解。否则无法访问到controller
@EnableAutoConfiguration
public class HelloController {

    @Autowired
    private JdbcConfiguration jdbcConfiguration;

    @GetMapping("show")
    public String test(){
        return "hello springboot 1";
    }

//尽管任意一个类都可以加上下面这段代码来变成引导类，但这样无法保证所有类都能被扫描到，且引导类不应包含业务逻辑，因此不推荐这种方式
//    public static void main(String[] args) {
//        SpringApplication.run(HelloController.class, args);
//    }

}
