package com.ccorder.ordersystem.controller;


import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.SysDict;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.SysDictMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.service.FoodService;
import com.ccorder.ordersystem.service.SysUserService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import java.util.*;

/**
 * @author zm
 * @description
 * @data 2019/5/12
 */
@Controller
@RequestMapping(value = "/food")
@Api(tags = "食品API")
public class FoodController {

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    private FoodService foodService;

    @Autowired
    private SysUserService userService;

    @Autowired
    private MapUserFoodMapper mapUserFoodMapper;

    @Autowired
    private SysDictMapper dictMapper;


    @ApiOperation(value = "后端测试")
    @GetMapping("getFoodName")
    @ResponseBody
    public Object getFoodName() {
        Food tmpFood = new Food();
        return new AjaxMessage().Set(MsgType.Success, "获取FoodName成功", tmpFood);
    }


    @ApiOperation(value = "(店铺管理模块)添加新的食品分类")
    @PostMapping("/addNewType")
    @ResponseBody
    public Object addNewType(
            @ApiParam(name = "newFoodType", value = "新的Food种类(中文)", required = true,type = "String")
            @RequestParam
                    String newFoodType,
            @ApiParam(name = "openId", value = "当前微信用户的唯一标识", required = true,type = "String")
            @RequestParam
                    String openId,
            @ApiParam(name = "sortNum", value = "类别排序数字", required = true, type = "Integer")
            @RequestParam
                    Integer sortNum
    ) {
        SysUser userNow = userService.selectByPrimaryKey(openId);

        /*获取食品类别的dict_type_id*/
        String dictTypeId = dictMapper.selectByNameEnAndStatus("foodType", 0);
        SysDict newSysDict = new SysDict();
        newSysDict.setId(UUID.randomUUID().toString());
        newSysDict.setNameCn(newFoodType);
        newSysDict.setSort(sortNum);

        Date dateNow = new Date();
        newSysDict.setCreateUserId(userNow.getId());
        newSysDict.setModifyUserId(userNow.getId());
        newSysDict.setCreateDate(dateNow);
        newSysDict.setModifyDate(dateNow);

        try {
            dictMapper.insertSelective(newSysDict);
            return new AjaxMessage().Set(MsgType.Success, "添加食品分类成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "添加食品分类失败");
    }


    @ApiOperation(value = "(店铺管理模块)添加新食物")
    @PostMapping("/addNewFood")
    @ResponseBody
    public Object addNewFood(
            @ApiParam(name = "newFood", value = "新的食物(需要设置foodType)", required = true, type = "Food")
            @RequestBody
                    Food newFood
    ) {
        /*user的openId在暂存在newFood中的createId中*/
        String openId = newFood.getCreateUserId();

        /*获取店家*/
        SysUser storeUser = userService.selectByPrimaryKey(newFood.getCreateUserId());
        System.out.println(storeUser);

        if (storeUser != null) {
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
                userFoodMap.setModifyUserId(storeUser.getId());
                Date tmpDate = new Date();
                userFoodMap.setCreateDate(tmpDate);
                userFoodMap.setModifyDate(tmpDate);
                mapUserFoodMapper.insertSelective(userFoodMap);
                return new AjaxMessage().Set(MsgType.Success, "新增Food成功");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new AjaxMessage().Set(MsgType.Error, "新增Food失败");
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
