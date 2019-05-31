package com.ccorder.ordersystem.service;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.UserFood;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.sys.utils.StringAndInteger;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.code.ORDER;

import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private MapOrderFoodMapper orderFoodMapper;

    public int addNewFood(Food newFood){
        return foodMapper.insertSelective(newFood);
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

    public List<Food> getFoodsByOrderId(String orderId) {
        List<StringAndInteger> mapFoodAmount = new ArrayList<>();
        List<Food> foodList = new ArrayList<>();
        /*获取foodId和amount*/
        mapFoodAmount = orderFoodMapper.selectFoodIdAndAmountByOrderId(orderId);
        for (StringAndInteger foodAndAmount : mapFoodAmount) {
            Food tmpFood = new Food();

            /*根据id获取food*/
            tmpFood = foodMapper.selectByPrimaryKey(foodAndAmount.getStringParam());
            System.out.println(foodAndAmount);
            tmpFood.setFoodAmount(foodAndAmount.getIntegerParam());
            foodList.add(tmpFood);
        }
        return foodList;
    }
}
