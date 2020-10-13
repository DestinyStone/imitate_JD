package com.imitatejd.maven.imitatejd_passport_controller;

import annon.EnableShiro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableShiro
public class ImitatejdPassportControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImitatejdPassportControllerApplication.class, args);
    }

}
