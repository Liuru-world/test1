package com.ewy.wms2light.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Mapper
@Repository
public interface LogMapper {
    public List<HashMap<String,Object>> getLogs();
}
