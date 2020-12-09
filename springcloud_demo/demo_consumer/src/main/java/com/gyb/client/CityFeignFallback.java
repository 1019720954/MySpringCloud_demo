package com.gyb.client;

import com.gyb.pojo.CityInfo;
import org.springframework.stereotype.Component;

@Component
public class CityFeignFallback implements CityFeignClient {
    @Override
    public CityInfo getCity(Integer id) {
        CityInfo cityInfo = new CityInfo();
        cityInfo.setCname("对不起服务异常");
        return cityInfo;
    }
}
