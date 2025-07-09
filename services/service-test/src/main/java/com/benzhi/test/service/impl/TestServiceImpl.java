package com.benzhi.test.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.benzhi.test.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @SentinelResource(value = "sayHello", blockHandler = "sayHelloFallback")
    @Override
    public String sayHello() {
        return "你好啊";
    }

    // 兜底调用
    public String sayHelloFallback(BlockException e) {
        return e.getMessage();

    }
}
