package com.ccorder.ordersystem.mapper.mapMapper;


import com.ccorder.ordersystem.entity.mapEntity.MapUserOrder;

import java.util.List;

public interface MapUserOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapUserOrder record);

    int insertSelective(MapUserOrder record);

    MapUserOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapUserOrder record);

    int updateByPrimaryKey(MapUserOrder record);

    List<String> selectByUserIdGetOrderId(String userId);


}