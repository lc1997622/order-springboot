package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.MapUserRole;

public interface MapUserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapUserRole record);

    int insertSelective(MapUserRole record);

    MapUserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapUserRole record);

    int updateByPrimaryKey(MapUserRole record);
}