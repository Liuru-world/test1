package com.ewy.wms2light.controller;

import com.ewy.wms2light.entity.Good;
import com.ewy.wms2light.exception.ParamException;
import com.ewy.wms2light.exception.ServerErrorException;
import com.ewy.wms2light.service.impl.GoodServiceImpl;
import com.ewy.wms2light.utils.HttpCodeEnum;
import com.ewy.wms2light.utils.HttpReturn;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodServiceImpl goodService;

    //查询所有
    @GetMapping("/goodList")
    @ApiOperation(value = "Get the Goods",notes = "no need any params")
    @ApiResponses({
            @ApiResponse(code = 200,message = "请求正确"),
            @ApiResponse(code = 400,message = "参数错误"),
            @ApiResponse(code = 404,message = "页面没找到"),
            @ApiResponse(code = 500,message = "服务错误")
    })
    public HttpReturn getGoods(){
            try {
                List<Good> goods = goodService.getGoods();
                log.info("查询货品成功");
                return new HttpReturn(HttpCodeEnum.OK,goods);
            }catch (Exception e){
                log.error("查询货品失败");
                throw new ParamException(400,"查询货品失败");
            }
    }

    //按条码、分拣单号查询
    @GetMapping("/goodByBarcode/{barcode}")
    public HttpReturn getGoodByBarcode(Good good){
        try {
            Good good1 = goodService.getGoodByBarcode(good);
            log.info("根据条码查询货品成功");
            return new HttpReturn(HttpCodeEnum.OK,good1);
        }catch (Exception e){
            log.error("根据条码查询货品失败");
            throw new ParamException(400,"根据条码查询货品失败");
        }
    }
    //按出库单号查询
    @GetMapping("/goodsByStockoutno/{stockoutno}")
    public HttpReturn getGoodsByStockoutno(@PathVariable String stockoutno){
        try {
            List<Good> goods = goodService.getGoodsByStockoutno(stockoutno);
            log.info("根据出库单号查询货品成功");
            return new HttpReturn(HttpCodeEnum.OK,goods);
        }catch (Exception e){
            log.error("根据出库单号查询货品失败");
            throw new ParamException(400,"根据出库单号查询货品失败");
        }
    }
    //按条码、分拣单号修改
    @PostMapping("/goodUpdateByBarcode")
    public HttpReturn updateGoodByBarcode(Good good){
        try {
            Integer i = goodService.updateGoodByBarcode(good);
            log.info("修改货品成功");
            return new HttpReturn(HttpCodeEnum.OK,"成功修改" + i + "件货品");
        }catch (Exception e){
            log.error("修改货品失败");
            throw new ServerErrorException(500,"修改货品失败");
        }
    }
}
