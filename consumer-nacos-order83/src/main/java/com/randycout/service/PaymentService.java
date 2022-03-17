package com.randycout.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
@Service
@FeignClient("nacos-payment")
public interface PaymentService {
    @GetMapping("/nacos/payment/port")
    String getPort();
    @GetMapping("/payment/get")
    String getOK();
}
