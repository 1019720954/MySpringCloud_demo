package com.gyb.controller;

import com.gyb.pojo.CityInfo;
import com.gyb.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;
    @RequestMapping("/{id}")
//    public CityInfo getCity(@PathVariable Integer id){
//        // 为了演示超时现象，我们在这里让线程休眠,时间随机 0~2000毫秒
//        try {
//            Thread.sleep(new Random().nextInt(2000));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return cityService.findById(id);
//    }

//    public CityInfo getCity(@PathVariable Integer id){
//        // 为了演示超时现象，我们在这里让线程休眠2000毫秒
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return cityService.findById(id);
//    }

    public CityInfo getCity(@PathVariable("id") Integer id){
        // 为了让超时可控，我们在这里引发异常
        System.out.println(id);
        if (id==2){
            throw new RuntimeException();
        }
        return cityService.findById(id);
    }
}
