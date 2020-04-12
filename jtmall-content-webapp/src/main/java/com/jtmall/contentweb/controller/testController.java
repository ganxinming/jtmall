package com.jtmall.contentweb.controller;

import com.jtmall.contentInterface.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Badribbit
 * @create 2020/3/3 15:00
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class testController {

    @Reference(version = "${demo.service.content}",check = false)
    private UserService userService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
            return  userService.testRedis();
    }
}
