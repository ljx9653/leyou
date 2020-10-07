package com.ljx.microservice.serviceprovider.service;

import com.ljx.microservice.serviceprovider.mapper.UserMapper;
import com.ljx.microservice.serviceprovider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijx
 * @date 2019/12/17 - 10:14
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }
}
