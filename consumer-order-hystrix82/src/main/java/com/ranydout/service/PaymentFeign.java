package com.ranydout.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
@FeignClient(value = "HYSTRIX-PAYMENT")
public interface PaymentFeign {
    @GetMapping("/payment/hystrix/timeout")//提供者需要3秒钟才能完成
    String timeout() throws InterruptedException;
    @GetMapping("/payment/hystrix/ok")
    String timeOk();
}
