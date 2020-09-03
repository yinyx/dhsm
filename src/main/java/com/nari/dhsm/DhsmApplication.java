package com.nari.dhsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DhsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhsmApplication.class, args);
    }

}
