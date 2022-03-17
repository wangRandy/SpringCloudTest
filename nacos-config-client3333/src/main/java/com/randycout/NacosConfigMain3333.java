package com.randycout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigMain3333 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigMain3333.class,args);
    }
}
