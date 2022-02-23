package com.whahn.infra;

import com.whahn.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// https://api.github.com/repos/OpenFeign/feign/contributors
@FeignClient(value = "feign", url = "http://localhost:9000", configuration = FeignConfig.class)
public interface FeignTest {
    @GetMapping("/test")
    void getTest();
}
