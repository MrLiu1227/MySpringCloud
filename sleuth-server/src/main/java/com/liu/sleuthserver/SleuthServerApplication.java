package com.liu.sleuthserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SleuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthServerApplication.class, args);
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home(){
        return "i'm sleuth-server！";
    }

    @RequestMapping("/server-info")
    public String info(){
        return restTemplate.getForObject("http://localhost:8988/hi",String.class);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
