package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.MapOrderComment;

public interface MapOrderCommentMapper {
    int insert(MapOrderComment record);

    int insertSelective(MapOrderComment record);
}