package com.ewy.wms2light.controller;

import com.ewy.wms2light.entity.Head;
import com.ewy.wms2light.exception.ServerErrorException;
import com.ewy.wms2light.service.impl.HeadServiceImpl;
import com.ewy.wms2light.utils.HttpCodeEnum;
import com.ewy.wms2light.utils.HttpReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/head")
public class HeadController {
    @Autowired
    private HeadServiceImpl service;
    //修改主头表状态
    @PostMapping("/headStatusUpdate")
    public HttpReturn updateHeadStatus(Head head){
        try {
            Integer i = service.updateHeadStatus(head);
            log.info("修改分拣单状态成功");
            return new HttpReturn(HttpCodeEnum.OK,"成功修改" + i + "条分拣单状态");
        }catch (Exception e){
            log.error("修改分拣单状态失败");
            throw new ServerErrorException(500,"修改分拣单状态失败");
        }
    }

    // 根据id删除用户
    @DeleteMapping("/userDeleteByPickno/{pickno}")
    public HttpReturn deleteUserById(String pickno){
        try {
            Integer i = service.deleteHead(pickno);
            log.info("删除分拣单成功");
            return new HttpReturn(HttpCodeEnum.OK,"成功删除" + i + "条分拣单");
        }catch (Exception e){
            log.error("删除分拣单失败");
            throw new ServerErrorException(500,"删除分拣单失败");
        }
    }
}
