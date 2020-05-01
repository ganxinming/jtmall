package com.jtmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * JtmallContentWebApplication
 * 消费者启动类
 * @author xiaoze
 * @date 2018/6/7
 */
@EnableDubbo
@SpringBootApplication
public class JtmallCartWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(JtmallCartWebApplication.class, args);
    }
}
