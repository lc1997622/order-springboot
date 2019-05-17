package com.ccorder.ordersystem.controller;


import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author zm
 * @description
 * @data 2019/5/12
 */
@Controller
@RequestMapping(value = "/food")
@ResponseBody
public class FoodController {

    @Autowired
    FoodMapper foodMapper;

    @GetMapping("getFoodName")
    public Object getFoodName(){

        return new AjaxMessage().Set(MsgType.Success, "个人中心加载完毕", "hello");
    }


    @ApiOperation(value = "获取食物列表")
    @GetMapping("getFoodList")
    public Object getFoodList(){

        @Data
        class kindFoods{
            String type;
            Food[] typeFoodList;
            kindFoods(String type,Food[] foods){
                this.type = type;
                this.typeFoodList = foods;
            }
        }
        List<Map<String,Object>> types = foodMapper.getAllType();
        List<String> foodtypes = new ArrayList<>();
        List<kindFoods> foodsList = new ArrayList<>();

        for (int i = 0 ; i < types.size();i++){
            foodtypes.add(types.get(i).get("foodType").toString());
        }
        for (int i = 0; i< foodtypes.size();i++){
            Food[] foods = foodMapper.getFoodsByType(foodtypes.get(i));
            foodsList.add(new kindFoods(foodtypes.get(i),foods));
        }

        return new AjaxMessage().Set(MsgType.Success,"食品列表",foodsList);
    }


}
