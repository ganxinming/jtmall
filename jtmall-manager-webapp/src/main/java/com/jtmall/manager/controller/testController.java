package com.jtmall.manager.controller;

import com.jtmall.service.RedisService;
import com.jtmall.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * @Author Badribbit
 * @create 2020/3/3 15:00
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class testController {

    @Reference(version = "${demo.service.manager}")
    private RedisService redisUtils;

    @Reference(version = "${demo.service.manager}")
    private UserService userService;

    @RequestMapping(value = "/hello/{id}")
    @ResponseBody
    public void hello(@PathVariable(value = "id") String id){
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id);
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id);
            str = object.toString();
            System.out.println(str);
        }else{
            //从数据库中获取信息
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,id,10L, TimeUnit.MINUTES);
            System.out.println("随机数");
        }

    }

}
