package com.gyb.service;

import com.gyb.pojo.CityInfo;

import java.util.List;

public interface CityService{
    List<CityInfo> findAll();
    CityInfo findById(Integer id);
    void del();
}
