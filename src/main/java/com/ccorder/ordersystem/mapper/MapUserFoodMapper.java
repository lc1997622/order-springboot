package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.MapUserFood;

public interface MapUserFoodMapper {
    int insert(MapUserFood record);

    int insertSelective(MapUserFood record);
}