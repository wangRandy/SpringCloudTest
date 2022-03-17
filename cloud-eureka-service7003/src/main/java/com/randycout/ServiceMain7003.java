package com.randycout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceMain7003 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain7003.class,args);
    }
}
