package com.gyb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker //服务熔断
//@SpringBootApplication //Boot应用
//@EnableDiscoveryClient //负载均衡
@EnableFeignClients
@SpringCloudApplication //一个标准的cloud消费配置，包含了以上三种注解
public class ComApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComApplication.class);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        // 默认的RestTemplate，底层是走JDK的URLConnection方式。
        return new RestTemplate();
    }
}
