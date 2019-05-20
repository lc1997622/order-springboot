package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapUserRole;
import org.apache.ibatis.annotations.Param;

public interface MapUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapUserRole record);

    int insertSelective(MapUserRole record);

    MapUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapUserRole record);

    int updateByPrimaryKey(MapUserRole record);

    String selectByUserId(String userId);
}