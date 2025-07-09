package com.benzhi.test.controller;

import com.benzhi.test.feign.TestFeignClient;
import com.benzhi.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TestController {

    @Autowired
    TestFeignClient testFeignClient;

    @Autowired
    TestService testService;


    @GetMapping("/sayHello")
    public String hello()
    {
        log.info("say hello");
        return testService.sayHello();
    }

    @GetMapping("/UseFeignSayHello")
    public String feignSayhello()
    {
        log.info("say hello by feign");
        return testFeignClient.hello();
    }

}
