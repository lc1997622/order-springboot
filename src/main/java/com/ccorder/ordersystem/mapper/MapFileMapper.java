package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.MapFile;

public interface MapFileMapper {
    int insert(MapFile record);

    int insertSelective(MapFile record);
}