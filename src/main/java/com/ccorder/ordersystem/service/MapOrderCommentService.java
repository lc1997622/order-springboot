package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.MapOrderCommentMapper;
import com.ccorder.ordersystem.entity.MapOrderComment;
@Service
public class MapOrderCommentService{

    @Resource
    private MapOrderCommentMapper mapOrderCommentMapper;

    
    public int insert(MapOrderComment record) {
        return mapOrderCommentMapper.insert(record);
    }

    
    public int insertSelective(MapOrderComment record) {
        return mapOrderCommentMapper.insertSelective(record);
    }

}
