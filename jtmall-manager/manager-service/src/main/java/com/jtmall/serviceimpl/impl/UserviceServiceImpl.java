package com.jtmall.serviceimpl.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jtmall.entity.User;
import com.jtmall.serviceimpl.mapper.UserMapper;
import com.jtmall.service.UserviceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Badribbit
 * @create 2020/1/9 9:49
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.version}")
public class UserviceServiceImpl implements UserviceService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByid() {
        User user=new User();
        user.setUsername(userMapper.getUser());
        return user;
    }
}
