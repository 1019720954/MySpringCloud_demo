package com.gyb.controller;

import com.gyb.client.CityFeignClient;
import com.gyb.pojo.CityInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    RestTemplate restTemplate;
//    @Autowired
//    DiscoveryClient discoveryClient;
    /**
     * ribbon 负载均衡
     */

//    @RequestMapping("/{id}")
//    public CityInfo CallCityInfo(@PathVariable Integer id){
////        List<ServiceInstance> instances = discoveryClient.getInstances("demo-service");
////        ServiceInstance instance = instances.get(0);
//        //String url = "http://localhost:8086/city/"+id;
////        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/city/"+id;
//        String url = "http://demo-service/city/"+id;
//        CityInfo cityInfo = restTemplate.getForObject(url, CityInfo.class);
//        return cityInfo;
//    }
    /**
     * @HystrixCommand(fallbackMethod ="指定降级通知的回调方法")
     */
//    @RequestMapping("/{id}")
//    @HystrixCommand(fallbackMethod ="CallCityInfoFallback")
//    public String CallCityInfo(@PathVariable Integer id){
//        String url = "http://demo-service/city/"+id;
//        return restTemplate.getForObject(url, String.class);
//    }
//    //此方法要求：与CallCityInfoFallback()方法的参数和返回类型都必须一致，为了方便返回消息所有对原来的方法做改造。
//    public String CallCityInfoFallback(Integer id){
//        return "不好意思,服务器开小差了!";
//    }
    /**
     * @HystrixCommand 使用默认的降级方法
     */
//    @RequestMapping("/{id}")
//    @HystrixCommand
//    public String CallCityInfo(@PathVariable Integer id){
//        String url = "http://demo-service/city/"+id;
//        return restTemplate.getForObject(url, String.class);
//    }
//    //该方法没有参数，是所有方法的回调方法，一般返回String
//    public String defaultFallback(Integer id){
//        return "不好意思，网络走丢了~~~";
//    }
    /**
     * @HystrixCommand(fallbackMethod = "CallCityInfoFallback",commandProperties = {
     *             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
     *     })
     * 指定特殊的业务需要调整hystrix的超时时间
     */
//    @RequestMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "CallCityInfoFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
//    }) //声明一个失败回滚处理函数
//    public String CallCityInfo(@PathVariable Integer id){
//        String url = "http://demo-service/city/"+id;
//        return restTemplate.getForObject(url, String.class);
//    }
//    //该方法没有参数，是所有方法的回调方法，一般返回String
//    public String CallCityInfoFallback(Integer id){
//        return "不好意思，网络走丢了~~~";
//    }
    /**
     * @HystrixCommand(fallbackMethod = "CallCityInfoFallback",commandProperties = {
     *             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value="3000")
     *     })
     * 指定特殊的业务需要调整hystrix的超时时间
     */
//    @RequestMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "CallCityInfoFallback",commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value="10"),//断路器请求次数
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value="60"),//失败比例
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value="10000")//休眠时间
//    })//声明一个失败回滚处理函数
//    public String CallCityInfo(@PathVariable Integer id){
//        String url = "http://demo-service/city/"+id;
//        return restTemplate.getForObject(url, String.class);
//    }
//    //该方法没有参数，是所有方法的回调方法，一般返回String
//    public String CallCityInfoFallback(Integer id){
//        return "不好意思，网络走丢了~~~";
//    }
    @Autowired
    private CityFeignClient cityFeignClient;
    @RequestMapping("/{id}")
    @HystrixCommand
    public CityInfo CallCityInfo(@PathVariable("id") Integer id){
        return cityFeignClient.getCity(id);
    }
}
