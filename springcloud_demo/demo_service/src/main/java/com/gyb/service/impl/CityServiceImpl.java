package com.gyb.service.impl;

import com.gyb.mapper.CityMapper;
import com.gyb.pojo.CityInfo;
import com.gyb.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("cityService")
@CacheConfig(cacheNames = "cityList")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;
    @Override
    @Cacheable
    public List<CityInfo> findAll() {
        return cityMapper.selectAll();
    }

    @Override
    public CityInfo findById(Integer id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public void del() {
        cityMapper.deleteByPrimaryKey(7);
    }
}
