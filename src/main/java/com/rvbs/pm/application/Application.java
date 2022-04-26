package com.rvbs.pm.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan({"com.rvbs.pm.*"})
@MapperScan(basePackages = {"com.rvbs.pm.mapper"})
@EnableMPP
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

