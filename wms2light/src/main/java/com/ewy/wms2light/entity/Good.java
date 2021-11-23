package com.ewy.wms2light.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Good {
    private String stockoutno;
    private String barcode;
    private Date scandate;
    private String scanby;
    private String color;
    private String statusno;
    private String pickno;
}
