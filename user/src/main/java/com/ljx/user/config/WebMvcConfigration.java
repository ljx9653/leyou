package com.ljx.user.config;

import com.ljx.user.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lijx
 * @date 2019/12/3 - 11:25
 *
 *   配置拦截器
 *   1.声明该类是一个java配置类
 *   2.实现WebMvcConfigurer接口
 */
@Configuration
public class WebMvcConfigration implements WebMvcConfigurer {

    @Autowired
    MyInterceptor myInterceptor;

    //需重写添加拦截器的方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加后还需指定需要拦截的路径或者不拦截的路径，/*只拦截一级，/**拦截多级
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
