package com.randycout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain6500 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain6500.class,args);
    }
}
