package com.ljx.user.service;

import com.ljx.user.mapper.UserMapper;
import com.ljx.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lijx
 * @date 2019/12/3 - 16:01
 */
@Service
public class UserService {

    //这里的报错属于idea误报，因为UserMapper的@Mapper注解并非spring官方提供的，idea不识别，但实际上已经注入了
    @Autowired
    UserMapper userMapper;

    public User queryUserById(Long id){
        return this.userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void deleteUserById(Long id){
        this.userMapper.deleteByPrimaryKey(id);
    }

    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }
}
