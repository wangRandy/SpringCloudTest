package com.randycout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//服务端(注册中心)
@SpringBootApplication
public class ServiceMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceMain7001.class,args);
    }
}
