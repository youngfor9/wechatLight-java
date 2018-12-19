package com.yang.dialogue_project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.dao")
public class DialogueProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(DialogueProjectApplication.class, args);
    }

}

