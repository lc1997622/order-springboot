package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.File;

public interface FileMapper {
    int deleteByPrimaryKey(String id);

    int insert(File record);

    int insertSelective(File record);

    File selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}