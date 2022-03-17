package com.randycout.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentNacosController {
    @Value("${server.port}")
    private String port;
    @GetMapping("/nacos/payment/port")
    public String getPort(){
        return port;
    }
    @GetMapping("/payment/get")
    public String getOK(){
        return "order访问成功,端口号为:"+port;
    }
}
