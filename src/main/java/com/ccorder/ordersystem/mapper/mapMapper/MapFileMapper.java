package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapFile;

public interface MapFileMapper {
    int insert(MapFile record);

    int insertSelective(MapFile record);
}