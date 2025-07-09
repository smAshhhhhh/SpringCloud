package com.benzhi.test.feign.fallback;

import com.benzhi.test.feign.TestFeignClient;
import org.springframework.stereotype.Component;

@Component
public class TestFeignClientFallback implements TestFeignClient {
    @Override
    public String  hello()
    {
        System.out.println("触发兜底回调");
        return null;
    }
}
