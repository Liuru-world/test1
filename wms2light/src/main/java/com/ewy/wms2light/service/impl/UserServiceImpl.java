package com.ewy.wms2light.service.impl;

import com.ewy.wms2light.apiinfos.UserInfo;
import com.ewy.wms2light.entity.User;
import com.ewy.wms2light.mapper.UserMapper;
import com.ewy.wms2light.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.findUsers();
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }
}
