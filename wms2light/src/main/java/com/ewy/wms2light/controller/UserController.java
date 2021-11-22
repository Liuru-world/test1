package com.ewy.wms2light.controller;

import com.alibaba.fastjson.JSON;
import com.ewy.wms2light.entity.User;
import com.ewy.wms2light.exception.ParamException;
import com.ewy.wms2light.exception.ServerErrorException;
import com.ewy.wms2light.service.UserService;
import com.ewy.wms2light.utils.HttpCodeEnum;
import com.ewy.wms2light.utils.HttpReturn;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 根据id获取用户(此方法可用于测试数据库连接、异常、RESTful风格、git、Swagger以及日志)
    @GetMapping("/userById/{id}")
    @ApiOperation(value = "Get the User By Id",notes = "id need integer type")
    @ApiResponses({
            @ApiResponse(code = 200,message = "请求正确"),
            @ApiResponse(code = 400,message = "参数错误"),
            @ApiResponse(code = 404,message = "页面没找到"),
            @ApiResponse(code = 500,message = "服务错误")
    })
    public HttpReturn getUserById(@PathVariable("id") Integer id){
        try {
            User user = new User();
            user = userService.getUserById(id);
            log.info("根据id查询用户成功");
    //      int i = 1/0;
            return new HttpReturn(HttpCodeEnum.OK,user);
        }catch (Exception e){
            log.error("根据id查询用户失败");
            throw new ParamException(400,"根据id查询用户失败");
        }
    }

    // 返回所有用户
    @GetMapping("/userlist")
    public HttpReturn getUsers(){
        try {
            List<User> users = userService.getUsers();
            log.info("查询用户列表成功");
            return new HttpReturn(HttpCodeEnum.OK,users);
        }catch (Exception e){
            log.error("查询用户列表失败");
            throw new ParamException(400,"查询用户列表失败");
        }
    }

    // 增加用户
    @PutMapping("/userInsert")
    public HttpReturn insertUser(){
        try {
            User user = new User();
            user.setName("test3");
            user.setPassword("12345678");
            user.setPhonenumber("18718795795");
            user.setWarehouseno("12345");
            user.setRole("2");
            Integer i = userService.insertUser(user);
            log.info("增加用户成功");
            return new HttpReturn(HttpCodeEnum.CREATEOK,"成功增加" + i + "名用户");
        }catch (Exception e){
            log.error("增加用户失败");
            throw new ServerErrorException(500,"增加用户失败");
        }
    }
}
