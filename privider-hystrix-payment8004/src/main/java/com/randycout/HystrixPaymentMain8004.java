package com.randycout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker//断路器
@EnableHystrix//@EnableHystrix是EnableCircuitBreaker的子类,断路器该有的功能它都有
public class HystrixPaymentMain8004 {//springBoot入口
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8004.class,args);
    }
}
