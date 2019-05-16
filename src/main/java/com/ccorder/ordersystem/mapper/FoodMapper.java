package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.Food;

public interface FoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

}