package com.benzhi.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //开启服务发现功能
@EnableFeignClients //开启Feign远程调用功能
public class TestMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMainApplication.class, args);
    }
}
