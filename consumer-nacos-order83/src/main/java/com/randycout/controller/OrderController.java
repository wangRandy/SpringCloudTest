package com.randycout.controller;

import com.randycout.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    PaymentService paymentService;
    @GetMapping("/order/nacos/payment/get")
    public String getPayment(){
        return paymentService.getPort();
    }
    @GetMapping("/payment/get")
    public String getok(){
        return paymentService.getOK();
    }
}
