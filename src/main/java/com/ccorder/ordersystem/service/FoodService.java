package com.ccorder.ordersystem.service;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.UserFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public UserFood[] getUserFood(){
        return foodMapper.getUserFood();
    }

    public List<Map<String,Object>> getAllType(){
        return foodMapper.getAllType();
    }

    public UserFood[] getFoodsByType(String type){
        return foodMapper.getFoodsByType(type);
    }
}
