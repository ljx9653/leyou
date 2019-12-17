package com.ljx.microservice.serviceprovider.mapper;


import com.ljx.microservice.serviceprovider.pojo.User;

/**
 * @author lijx
 * @date 2019/12/3 - 15:56
 */
//此处不采用在每个mapper上使用@Mapper注解的方式，而是采用在启动类上开启mapper扫描
//@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User>{
}
