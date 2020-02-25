package com.jtmall.serviceimpl;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DubboProviderApplication
 * 服务提供启动类
 * @author xiaoze
 * @date 2018/6/7
 */
@EnableDubbo
@SpringBootApplication
@MapperScan("com.jtmall.serviceimpl.mapper")
public class JtmallManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtmallManagerApplication.class, args);
    }

}
