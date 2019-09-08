package com.liu.sleuthclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SleuthClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthClientApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome(){
        return "i'm sleuth-client";
    }

    @RequestMapping("/client-info")
    public String info(){
        return restTemplate.getForObject("http://localhost:8989/hi",String.class);
    }


}
