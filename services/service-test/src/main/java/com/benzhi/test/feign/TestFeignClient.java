package com.benzhi.test.feign;


import com.benzhi.test.feign.fallback.TestFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service-test", fallback = TestFeignClientFallback.class)
public interface TestFeignClient {

    @GetMapping("/sayHello")
    String hello();
}
