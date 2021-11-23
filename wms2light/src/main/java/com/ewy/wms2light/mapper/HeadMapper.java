package com.ewy.wms2light.mapper;

import com.ewy.wms2light.entity.Head;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HeadMapper {
    //修改主单状态
    public Integer updateHeadStatus(Head head);
    //级联删除主单
    public Integer deleteHead(String pickno);

}
