package com.randycout;

import config.MyLoadbalancerRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient//客户端
@EnableFeignClients//激活openFeign
/*@RibbonClient(name = "PAYMENT",configuration = MyLoadbalancerRule.class)*///ribbon联合restTemplate实现负载均衡
public class OrderOpenFeignMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain81.class,args);
    }
    @LoadBalanced//这个注解在这里啊(卡了好久)
    @Bean//相当于把restTemplate对象丢进容器
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

