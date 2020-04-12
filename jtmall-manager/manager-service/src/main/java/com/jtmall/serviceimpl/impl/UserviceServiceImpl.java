package com.jtmall.serviceimpl.impl;

import com.jtmall.service.UserService;
import com.jtmall.serviceimpl.mapper.JtbItemMapper;
import com.jtmall.serviceimpl.mapper.JtbItemcontentMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Badribbit
 * @create 2020/1/9 9:49
 * @Define
 * @Tutorials
 * @Opinion
 */
@Service(version = "${demo.service.manager}")
public class UserviceServiceImpl  implements UserService {

    @Autowired
    JtbItemMapper jtbItemMapper;
    @Autowired
    JtbItemcontentMapper jtbItemcontentMapper;

    @Override
    public void testRedis() {
        System.out.println("调用了User");
    }
}
