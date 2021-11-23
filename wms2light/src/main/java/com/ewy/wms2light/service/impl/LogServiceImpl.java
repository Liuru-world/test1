package com.ewy.wms2light.service.impl;

import com.ewy.wms2light.mapper.LogMapper;
import com.ewy.wms2light.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public List<HashMap<String,Object>> getLogs() {
        return logMapper.getLogs();
    }
}
