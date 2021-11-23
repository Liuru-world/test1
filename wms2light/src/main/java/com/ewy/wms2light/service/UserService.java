package com.ewy.wms2light.service;

import com.ewy.wms2light.entity.User;

import java.util.List;

public interface UserService {
    //根据id获取用户
    public User getUserById(Integer id);
    //获取用户列表
    public  List<User> getUsers();
    // 按名字查询用户
    public List<User> getUsersByName(String keyWord);
    //增加用户
    public Integer insertUser(User user);
    // 修改用户
    Integer updateUser(User user);
    // 根据id删除用户
    Integer deleteUserById(Integer id);
}
