package com.jtmall.userService;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Badribbit
 * @create 2020/4/11 13:25
 * @Define
 * @Tutorials
 * @Opinion
 */
@EnableDubbo
@SpringBootApplication
@MapperScan(basePackages = "com.jtmall.userService.mapper")
public class JtmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtmallUserApplication.class, args);
    }

}
