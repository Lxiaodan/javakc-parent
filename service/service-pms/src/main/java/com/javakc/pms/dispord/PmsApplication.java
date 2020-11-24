package com.javakc.pms.dispord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @description: 测试类
 * @create 2020/11/2317:28
 */
@EnableJpaAuditing
@SpringBootApplication
@ComponentScan(basePackages = {"com.javakc"})
public class PmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsApplication.class, args);
    }

}
