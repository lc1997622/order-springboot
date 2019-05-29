package com.ccorder.ordersystem.mapper.mapMapper;
import org.apache.ibatis.annotations.Param;


import com.ccorder.ordersystem.entity.mapEntity.MapUserOrder;

import java.util.List;

public interface MapUserOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapUserOrder record);

    int insertSelective(MapUserOrder record);

    MapUserOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapUserOrder record);

    int updateByPrimaryKey(MapUserOrder record);

    /** 根据orderId获取userId*/
    List<String> selectByUserIdGetOrderId(String userId);

    /** 根据userId获取orderId*/
    List<String> selectOrderIdByUserId(@Param("userId")String userId);
}