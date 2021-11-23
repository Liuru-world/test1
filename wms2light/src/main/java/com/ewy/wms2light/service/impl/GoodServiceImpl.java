package com.ewy.wms2light.service.impl;

import com.ewy.wms2light.entity.Good;
import com.ewy.wms2light.mapper.GoodMapper;
import com.ewy.wms2light.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> getGoods() {
        return goodMapper.getGoods();
    }

    @Override
    public Good getGoodByBarcode(String barcode) {
        return goodMapper.getGoodByBarcode(barcode);
    }

    @Override
    public List<Good> getGoodsByStockoutno(String stockoutno) {
        return goodMapper.getGoodsByStockoutno(stockoutno);
    }

    @Override
    public Integer updateGoodByBarcode(Good good) {
        return goodMapper.updateGoodByBarcode(good);
    }
}
