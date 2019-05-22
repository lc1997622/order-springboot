package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapUserFoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapUserFood record);

    int insertSelective(MapUserFood record);

    MapUserFood selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapUserFood record);

    int updateByPrimaryKey(MapUserFood record);

    List<String> selectByUserIdGetFoodId(String userId);
}