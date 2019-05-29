package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.UserFood;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
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

    UserFood[] getFoodsByType(String type);

    UserFood[] getUserFood();

    List<String> selectByOrderIdGetFoodName(String orderId);

    Food selectByUserIdFoodId(String userId,String foodId);

    void deleteByFoodType(String foodType);

    String selectByFoodIdGetFoodName(String foodId);

    Double selectByFoodIdGetFoodPrice(String foodId);

    Food selectByFoodId(String foodId);

}