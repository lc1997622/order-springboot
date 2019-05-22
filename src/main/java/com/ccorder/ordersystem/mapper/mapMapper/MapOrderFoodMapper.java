package com.ccorder.ordersystem.mapper.mapMapper;
import com.ccorder.ordersystem.sys.utils.StringAndInteger;
import org.apache.ibatis.annotations.Param;

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

    Integer selectByFoodIdGetAmount(String foodId,String orderId);

    List<String> selectByOrderIdGetFoodId(String orderId);

    Integer selectByFoodIdGetAmount(String foodId);

    List<StringAndInteger> selectFoodIdAndAmountByOrderId(@Param("orderId")String orderId);
}