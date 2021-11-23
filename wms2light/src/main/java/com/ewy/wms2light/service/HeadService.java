package com.ewy.wms2light.service;

import com.ewy.wms2light.entity.Head;

public interface HeadService {
    //修改主头表状态
    public Integer updateHeadStatus(Head head);

    //级联删除主单
    public Integer deleteHead(String pickno);
}
