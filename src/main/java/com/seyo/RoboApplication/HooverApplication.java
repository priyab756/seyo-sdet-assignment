package com.seyo.RoboApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.seyo.rest", "com.seyo.hoover.service"})
@SpringBootApplication
public class HooverApplication {

    public static void main(String[] args) {
        SpringApplication.run(HooverApplication.class, args);
    }


}
