package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.MapOrderFood;

public interface MapOrderFoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapOrderFood record);

    int insertSelective(MapOrderFood record);

    MapOrderFood selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapOrderFood record);

    int updateByPrimaryKey(MapOrderFood record);
}