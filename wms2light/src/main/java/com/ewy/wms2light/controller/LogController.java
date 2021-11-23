package com.ewy.wms2light.controller;

import com.ewy.wms2light.exception.ServerErrorException;
import com.ewy.wms2light.service.impl.LogServiceImpl;
import com.ewy.wms2light.utils.HttpCodeEnum;
import com.ewy.wms2light.utils.HttpReturn;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private LogServiceImpl service;

    //查询所有
    @GetMapping("/logList")
    @ApiOperation(value = "Get the Logs",notes = "no need any params")
    @ApiResponses({
            @ApiResponse(code = 200,message = "请求正确"),
            @ApiResponse(code = 400,message = "参数错误"),
            @ApiResponse(code = 404,message = "页面没找到"),
            @ApiResponse(code = 500,message = "服务错误")
    })
    public HttpReturn getLogs(){
        try {
            List<HashMap<String,Object>> logs = service.getLogs();
            log.info("查询日志成功");
            return new HttpReturn(HttpCodeEnum.OK,logs);
        }catch (Exception e){
            log.error("查询日志失败");
            throw new ServerErrorException(500,"查询日志失败");
        }
    }
}
