package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.yang.dao")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DialogueProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(DialogueProjectApplication.class, args);
    }

}

