package com.ewy.wms2light.mapper;

import com.ewy.wms2light.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@Mapper
public interface GoodMapper {
    //查询所有
    public List<Good> getGoods();
    //按条码查询
    public Good getGoodByBarcode(Good good);
    //按出库单号查询
    public List<Good> getGoodsByStockoutno(String stockoutno);
    //按条码修改
    public Integer updateGoodByBarcode(Good good);
}
