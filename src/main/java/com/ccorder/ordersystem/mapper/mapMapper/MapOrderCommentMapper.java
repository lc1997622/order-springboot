package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapOrderComment;

public interface MapOrderCommentMapper {
    int insert(MapOrderComment record);

    int insertSelective(MapOrderComment record);
}