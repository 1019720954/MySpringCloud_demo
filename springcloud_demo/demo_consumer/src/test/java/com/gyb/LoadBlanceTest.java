package com.gyb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoadBlanceTest {
    @Autowired
    RibbonLoadBalancerClient rlc;
    @Test
    public void test(){
        for (int i=0; i<100; i++){
            ServiceInstance instance = rlc.choose("demo-service");
            System.out.println(instance.getPort());
        }
    }
}
