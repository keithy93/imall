package com.imooc.imall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.imooc.imall.mapper")
@EnableSwagger2
public class ImallApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImallApplication.class, args);
    }
}
