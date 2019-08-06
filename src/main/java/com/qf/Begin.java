package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.dao")
public class Begin {
    public static void main(String[] args) {
        SpringApplication.run(Begin.class,args);
    }
}
