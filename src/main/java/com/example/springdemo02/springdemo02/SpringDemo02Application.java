package com.example.springdemo02.springdemo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringDemo02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemo02Application.class, args);
    }

}
