package com.ranydout.controller;

import com.ranydout.service.PaymentFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController//不能写Controller,不然就要跳转页面了
public class OrderHystrix {
    @Resource
    PaymentFeign paymentFeign;
    @GetMapping("/consumer/payment/hystrix/ok")
    public String timeOk(){
        return paymentFeign.timeOk();
    }
    @GetMapping("/consumer/payment/hystrix/timeout")
    public String timeOut() throws InterruptedException {
        return paymentFeign.timeout();
    }
}
