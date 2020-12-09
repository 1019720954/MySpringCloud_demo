package com.gyb.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityInfo implements Serializable {
    private Integer cid;
    private String cname;
}

