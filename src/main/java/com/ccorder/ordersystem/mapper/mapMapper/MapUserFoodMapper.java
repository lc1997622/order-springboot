package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;

public interface MapUserFoodMapper {
    int insert(MapUserFood record);

    int insertSelective(MapUserFood record);
}