package com.ewy.wms2light.service;

import com.ewy.wms2light.entity.Good;

import java.util.List;
public interface GoodService {
    //查询所有
    public List<Good> getGoods();
    //按条码查询
    public Good getGoodByBarcode(String barcode);
    //按出库单号查询
    public List<Good> getGoodsByStockoutno(String stockoutno);
    //按条码修改
    public Integer updateGoodByBarcode(Good good);
}
