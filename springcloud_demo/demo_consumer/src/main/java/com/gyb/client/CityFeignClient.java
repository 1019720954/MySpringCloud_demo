package com.gyb.client;

import com.gyb.pojo.CityInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "demo-service", fallback = CityFeignFallback.class)
public interface CityFeignClient {
    @RequestMapping("/city/{id}")
    CityInfo getCity(@PathVariable("id") Integer id);
}
