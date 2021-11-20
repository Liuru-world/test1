package com.ewy.wms2light.exception;

import com.ewy.wms2light.utils.HttpCodeEnum;
import com.ewy.wms2light.utils.HttpReturn;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ParamException.class)
    public HttpReturn handleParamException(ParamException e){
       HttpCodeEnum httpCodeEnum;
       httpCodeEnum = HttpCodeEnum.PARAM_ERROR;
       return new HttpReturn(httpCodeEnum,e.getErrorMsg());
    }

    @ExceptionHandler(Exception.class)
    public HttpReturn handlerOtherException(Exception e){
        HttpCodeEnum httpCodeEnum;
        //其他异常，当定义了多个异常，这里可以增加判断和记录
        httpCodeEnum = HttpCodeEnum.SERVER_ERROR;
        return new HttpReturn(httpCodeEnum,e.getMessage());
    }

    @ExceptionHandler(ServerErrorException.class)
    public HttpReturn handlerOtherException(ServerErrorException e){
        HttpCodeEnum httpCodeEnum;
        httpCodeEnum = HttpCodeEnum.SERVER_ERROR;
        return new HttpReturn(httpCodeEnum,e.getMessage());
    }
}
