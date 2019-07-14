package com.liu.example.serviceclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloSevice {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String getHello(){
        return "hello! 我的端口号是：" + port;
    }
}
