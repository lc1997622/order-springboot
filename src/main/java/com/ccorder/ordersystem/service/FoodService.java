package com.ccorder.ordersystem.service;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.MapUserFood;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.MapUserFoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zm
 * @description
 * @data 2019/5/16
 */
@Service
public class FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private MapUserFoodMapper userFoodMapper;

    public int addNewFood(Food newFood){
        return foodMapper.insert(newFood);
    }

    public void addUserFoodRecord(MapUserFood userFood) {
        userFoodMapper.insertSelective(userFood);
    }
}
