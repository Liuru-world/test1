package com.ewy.wms2light.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String warehouseno;
    private String phonenumber;
    private String roleno;
}
