package com.randycout.controller;

import com.randycout.bean.CommonResult;
import com.randycout.bean.Payment;
import com.randycout.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController//=@Controller+@ResponseBody 注入Spring容器和返回字符串,不跳转页面
@Slf4j
public class OrderFeignController {

    /*public static final String PAYMENT_URL = "http://PAYMENT";
    @Resource
    private RestTemplate restTemplate;*/
    @Resource
    private PaymentFeignService paymentFeignService;
    /*@GetMapping("/consumer/payment/get/{id}") //getForObject返回的json对象
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("********查询的id：" + id);
        //getForObject两个参数：请求地址，返回的对象类型
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }*/
    @GetMapping("/consumer/feign/payment/get/{id}")//使用openfeign调用简单多了,不需要restTemplate,还自带默认的轮询负载策略
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
       return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("/consumer/feign/timeout")//使用openfeign调用简单多了,不需要restTemplate,还自带默认的轮询负载策略
    public String timeout() throws InterruptedException {
        return paymentFeignService.timeout();
    }


}
