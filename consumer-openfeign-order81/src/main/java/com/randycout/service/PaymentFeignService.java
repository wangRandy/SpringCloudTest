package com.randycout.service;

import com.randycout.bean.CommonResult;
import com.randycout.bean.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Service//放到容器中
@FeignClient(value = "PAYMENT")//在注册中心中的名字,表示要远程调用的微服务
public interface PaymentFeignService {//openFeign只用在消费端(客户端)
    @PostMapping("/payment/create")//新增
    CommonResult create(@RequestBody Payment payment);
    @GetMapping("/payment/get/{id}")//查询,直接抄袭PaymentController中的方法
    CommonResult getPaymentById(@PathVariable("id") Long id);
    @GetMapping("/payment/timeout")//提供者需要3秒钟才能完成
    String timeout() throws InterruptedException;
}
