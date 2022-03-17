package com.randycout.controller;

import com.randycout.bean.CommonResult;
import com.randycout.bean.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController//=@Controller+@ResponseBody 注入Spring容器和返回字符串,不跳转页面
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://PAYMENT";
    @Resource
    private RestTemplate restTemplate;
    //因为浏览器只支持get请求，为了方便这里就用get
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("********插入的数据：" + payment);
        //postForObject分别有三个参数：请求地址，请求参数，返回的对象类型
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    //getForObject返回的json对象
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("********查询的id：" + id);
        //getForObject两个参数：请求地址，返回的对象类型
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
    //getForEntity返回的是 ResponseEntity,包括的是一些响应体,响应头,响应状态码等信息
    @GetMapping("/consumer/payment2/get/{id}")
    public CommonResult<Payment> getEntityPayment(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(404,"找不到有关信息");
        }

    }
}
