package com.randycout.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SentinelController {

    @GetMapping("/sentinel/a")
    public String testA(){
        /*try {
            //睡1秒
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return "testA";
    }
    @GetMapping("/sentinel/b")
    public String testB(){
        return "testB";
    }
}
