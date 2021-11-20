package com.ewy.wms2light.service;

import com.ewy.wms2light.entity.User;

import java.util.List;

public interface UserService {
    //根据id获取用户
    public User getUserById(Integer id);
    //获取用户列表
    public  List<User> getUsers();
    //增加用户
    public Integer insertUser(User user);
}
