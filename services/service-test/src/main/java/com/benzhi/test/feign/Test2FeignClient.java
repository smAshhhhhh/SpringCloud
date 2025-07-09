package com.benzhi.test.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "weather", url = "http://www.7timer.info")
public interface Test2FeignClient {
    @PostMapping("/bin/astro.php")
    String getWeather(@RequestHeader("Authorization") String auth,
                             @RequestParam("id") int id);

}
