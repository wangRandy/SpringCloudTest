package com.randycout.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.concurrent.TimeUnit;

@RestController
@Slf4j  //日志
@DefaultProperties(defaultFallback = "globalFallBackMethod")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @HystrixCommand(fallbackMethod = "timeoutHandle",//服务降级的兜底方法
    commandProperties = {//服务降级的标准
            //设置自身超时调用时间的峰值为3秒，峰值内可以正常运行，超过了需要有兜底的方法处理，服务降级fallback
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/payment/hystrix/timeout")//提供者需要3秒钟才能完成
    public String timeout() throws InterruptedException {
       // int i=9/0;
        TimeUnit.SECONDS.sleep(2);//睡3秒
        return "需要等待2秒才能访问,端口号为:"+serverPort;
    }

    @GetMapping("/payment/hystrix/ok")
    @HystrixCommand//没有指明回调方法,就用全局的
    public String timeOk(){
        int i=1/0;
        return "正常访问,端口号为:"+serverPort;
    }
    @GetMapping("/payment/hystrix/circuitBreaker/{id}")//模拟断路器
    @HystrixCommand(fallbackMethod = "fallBack",
            commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求总数阈值（默认20）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//休眠时间窗口期（休眠多久进入半开模式（单位毫秒，默认5秒））
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//请求次数的错误率达到多少跳闸（百分率%，默认50%）
    })
    public String circuitBreaker(@PathVariable("id") Integer id){
        if (id <0 ) {
            throw new RuntimeException("id不能为负数");
        }
        return "访问成功,您输入的id是"+id;
    }


    //这是定制化的服务降级回调方法
   public String timeoutHandle(){
        return "[服务降级]调用timeout方法,超过3秒就会进行服务降级,调用timeoutHandle方法";
   }

   public String fallBack(@PathVariable("id") Integer id){//备用方法与原方法参数要一致
        return "id不能是负的,请重新输入";
   }
   //这是全局服务降级回调方法
   public String globalFallBackMethod(){
        return "这个是全局的服务降级回调方法";
   }

}

