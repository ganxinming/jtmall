package com.jtmall.password;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Badribbit
 * @create 2020/4/10 19:53
 * @Define
 * @Tutorials
 * @Opinion
 */
@SpringBootApplication
@EnableDubbo
public class JtmallPassportWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(JtmallPassportWebApplication.class, args);
    }
}
