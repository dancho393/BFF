package com.example.bff.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan(basePackages = {"com.example.bff"})
@EntityScan(basePackages = {"com.example.bff.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.example.bff.persistence.repositories"})
@EnableFeignClients(basePackages = {"com.example.bff"})
@SpringBootApplication
public class BffApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffApplication.class, args);
    }

}
