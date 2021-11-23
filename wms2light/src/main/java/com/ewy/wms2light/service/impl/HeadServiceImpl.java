package com.ewy.wms2light.service.impl;

import com.ewy.wms2light.entity.Head;
import com.ewy.wms2light.mapper.HeadMapper;
import com.ewy.wms2light.service.HeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeadServiceImpl implements HeadService {
    @Autowired
    private HeadMapper headMapper;
    @Override
    public Integer updateHeadStatus(Head head) {
        return headMapper.updateHeadStatus(head);
    }

    @Override
    public Integer deleteHead(String pickno) {
        return headMapper.deleteHead(pickno);
    }
}
