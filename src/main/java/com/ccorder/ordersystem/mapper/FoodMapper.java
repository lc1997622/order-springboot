package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FoodMapper {
    int deleteByPrimaryKey(String id);

    int insert(Food record);

    int insertSelective(Food record);

    Food selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

    Food[] getAllFood();

    List<Map<String,Object>> getAllType();

    Food[] getFoodsByType(String type);
}