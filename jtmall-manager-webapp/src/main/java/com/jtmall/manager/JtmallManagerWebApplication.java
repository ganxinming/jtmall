package com.jtmall.manager;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DubboConsumerApplication
 * 消费者启动类
 * @author xiaoze
 * @date 2018/6/7
 */
@EnableDubbo
@SpringBootApplication
public class JtmallManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtmallManagerWebApplication.class, args);
    }
}
