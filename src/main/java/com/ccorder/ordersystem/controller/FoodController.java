package com.ccorder.ordersystem.controller;


import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.MapUserFood;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.MapUserFoodMapper;
import com.ccorder.ordersystem.service.FoodService;
import com.ccorder.ordersystem.service.UserService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zm
 * @description
 * @data 2019/5/12
 */
@Controller
@RequestMapping(value = "/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private MapUserFoodMapper mapUserFoodMapper;

    @GetMapping("getFoodName")
    @ResponseBody
    public Object getFoodName(){
        Food tmpFood = new Food();
        return new AjaxMessage().Set(MsgType.Success, "获取FoodName成功", tmpFood);
    }

    /**
     * @param [newFood]
     * @return java.lang.Object
     * @Description 根据传入的newFood信息新增食品，createUserId就是门店的id
     * @author zm
     * @date 13:02 2019/5/16
     */
    public Object addNewFood(@RequestBody Food newFood){
        /*获取店家user*/
        SysUser storeUser = userService.getUserById(newFood.getCreateUserId());

        try {
            /*food表插入记录*/
            newFood.setId(UUID.randomUUID().toString());
            foodService.addNewFood(newFood);
            /*添加关联记录*/
            MapUserFood userFoodMap = new MapUserFood();
            userFoodMap.setId(UUID.randomUUID().toString());
            userFoodMap.setUserId(storeUser.getId());
            userFoodMap.setFoodId(newFood.getId());
            userFoodMap.setCreateUserId(storeUser.getId());
            userFoodMap.setCreateDate(new Date());
            mapUserFoodMapper.insertSelective(userFoodMap);
            return new AjaxMessage().Set(MsgType.Success,"新增Food成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error,"新增Food失败");
    }
    /**
     * @param [storeId]
     * @return java.lang.Object
     * @Description 根据店铺Id返回当前店铺的所有食品List
     * @author zm
     * @date 10:37 2019/5/16
     */
    public Object getStoreFood(
            @RequestParam("storeId") String storeId
    ){
        List<Food> foodList = new ArrayList<>();
        return new AjaxMessage().Set(MsgType.Success,"获取店铺所有商品成功", foodList);
    }
}
