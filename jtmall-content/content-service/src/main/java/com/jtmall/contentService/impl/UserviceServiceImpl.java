package com.jtmall.contentService.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jtmall.contentInterface.UserService;
import com.jtmall.contentService.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Badribbit
 * @create 2020/1/9 9:49
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.content}")
public class UserviceServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String testRedis() {

        return  userMapper.getUser();
    }
}
