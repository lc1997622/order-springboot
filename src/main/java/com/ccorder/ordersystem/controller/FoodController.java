package com.ccorder.ordersystem.controller;


import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.SysDict;
import com.ccorder.ordersystem.entity.UserFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.SysDictMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.service.FoodService;
import com.ccorder.ordersystem.service.SysDictService;
import com.ccorder.ordersystem.service.SysUserService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zm
 * @description
 * @data 2019/5/12
 */
@Controller
@RequestMapping(value = "/food")
@Api(tags = "食品Api")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private SysUserService userService;

    @Autowired
    private MapUserFoodMapper mapUserFoodMapper;

    @Autowired
    private SysDictMapper dictMapper;

    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private SysDictService sysDictService;


    @ApiOperation(value = "后端测试")
    @GetMapping("getFoodName")
    @ResponseBody
    public Object getFoodName() {
        Food tmpFood = new Food();
        return new AjaxMessage().Set(MsgType.Success, "获取FoodName成功", tmpFood);
    }

    @ApiOperation(value = "获取客户端食物列表")
    @GetMapping("getUserFoodList")
    @ResponseBody
    public Object getUserFoodList(){

        @Data
        class kindFoods{
            SysDict type;
            UserFood[] typeFoodList;
            kindFoods(SysDict type,UserFood[] userFoods){
                this.type = type;
                this.typeFoodList = userFoods;
            }
        }
        List<String> foodtypesID = new ArrayList<>();
        List<kindFoods> foodsList = new ArrayList<>();

        try{
            List<Map<String,Object>> types = foodService.getAllType();
            for (int i = 0 ; i < types.size();i++){
                foodtypesID.add(types.get(i).get("foodType").toString());
            }
            for (int i = 0; i< foodtypesID.size();i++){
                System.out.println(foodtypesID.get(i));
                UserFood[] userFoods = foodService.getFoodsByType(foodtypesID.get(i));
                foodsList.add(new kindFoods(sysDictService.selectByPrimaryKey(foodtypesID.get(i)),userFoods));
            }

            return new AjaxMessage().Set(MsgType.Success,"获取食品列表成功", foodsList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error,"获取食品列表失败");
    }

    @PostMapping("/addNewUserFood")
    @ResponseBody
    public Object addNewFood(
            @RequestBody
            UserFood userFood
    ){
        return new AjaxMessage().Set(MsgType.Success, "Just For Model");
    }

    @ApiOperation(value = "(店铺管理模块)添加新的食品分类")
    @PostMapping("/addNewType")
    @ResponseBody
    public Object addNewType(
            @ApiParam(name = "newFoodType", value = "新的Food种类(中文)", required = true,type = "SysDict")
            @RequestBody
                    SysDict newFoodType
    ) {
       Date nowDate=new Date();
       newFoodType.setId(UUID.randomUUID().toString());
       newFoodType.setCreateDate(nowDate);
       newFoodType.setModifyDate(nowDate);
       newFoodType.setDictType(newFoodType.getDictType());
       newFoodType.setSort(sysDictService.countAllRecords()+1);
       try {
            sysDictService.insertSelective(newFoodType);
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
                Date tmpDate = new Date();
                newFood.setId(UUID.randomUUID().toString());
                newFood.setCreateUserId(newFood.getCreateUserId());
                newFood.setModifyUserId(newFood.getModifyUserId());
                newFood.setCreateDate(tmpDate);
                newFood.setModifyDate(tmpDate);
                foodService.addNewFood(newFood);

                /*添加关联记录*/
                MapUserFood userFoodMap = new MapUserFood();
                userFoodMap.setId(UUID.randomUUID().toString());
                userFoodMap.setUserId(storeUser.getId());
                userFoodMap.setFoodId(newFood.getId());
                userFoodMap.setCreateUserId(storeUser.getId());
                userFoodMap.setModifyUserId(storeUser.getId());

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

    @ApiOperation(value = "商家删除某一个食品")
    @PostMapping("/deleteOneFood")
    @ResponseBody
    public Object deleteOneFood(
            @ApiParam(name = "foodId", value = "需要删除的食品的id", required = true, type = "String")
            @RequestParam
                    String foodId
    ) {
        try {
            if(foodMapper.selectByFoodId(foodId)==null){
                return new AjaxMessage().Set(MsgType.Success,"该食物不存在");
            }
            foodMapper.deleteByPrimaryKey(foodId);
            return new AjaxMessage().Set(MsgType.Success,"成功删除食物");
    }catch (Exception e){
        e.printStackTrace();
    }
        return new AjaxMessage().Set(MsgType.Success,"删除食物失败");
}

    @ApiOperation(value = "商家更新某一个食品的信息")
    @PostMapping("/updateOneFood")
    @ResponseBody
    public Object updateOneFood(
            @ApiParam(name = "food", value = "需要更新的食品", required = true, type = "Food")
            @RequestBody
                    Food food
    ) {
        try {
            //先判断food是否存在
            if(foodMapper.selectByFoodId(food.getId())==null){
                return new AjaxMessage().Set(MsgType.Success,"不存在此食物");
            }
            foodMapper.updateByPrimaryKeySelective(food);
            return new AjaxMessage().Set(MsgType.Success,"更新食物成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"更新食物失败");
    }

    @ApiOperation(value = "商家删除某一类的食物")
    @PostMapping("/deleteOneTypeFood")
    @ResponseBody
    public Object deleteOneTypeFood(
            @ApiParam(name = "foodType", value = "需要更新的食品", required = true, type = "String")
            @RequestParam
                    String foodType
    ) {
        try {
            foodMapper.deleteByFoodType(foodType);
            return new AjaxMessage().Set(MsgType.Success,"删除此类食物成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"删除此类食物失败");
    }
}
