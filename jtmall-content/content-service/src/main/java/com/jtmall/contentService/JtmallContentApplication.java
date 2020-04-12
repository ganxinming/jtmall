package com.jtmall.contentService;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DubboProviderApplication
 * 服务提供启动类
 * @author xiaoze
 * @date 2018/6/7
 */
@EnableDubbo
@SpringBootApplication
@MapperScan("com.jtmall.contentService.mapper")
@EnableTransactionManagement
public class JtmallContentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtmallContentApplication.class, args);
    }

}
