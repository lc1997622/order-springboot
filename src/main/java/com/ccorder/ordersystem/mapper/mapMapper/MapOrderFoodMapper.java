package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;

import java.util.List;

public interface MapOrderFoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapOrderFood record);

    int insertSelective(MapOrderFood record);

    MapOrderFood selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapOrderFood record);

    int updateByPrimaryKey(MapOrderFood record);

    List<Integer> selectByOrderIdGetAmount(String orderId);

    Integer seletcByFoodIdGetAmount(String foodId,String userId);

    List<String> selectByOrderIdGetFoodId(String orderId);

    Integer selectByFoodIdGetAmount(String foodId);
}