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
    public Object getUserFoodList() {

        @Data
        class kindFoods {
            SysDict type;
            UserFood[] typeFoodList;

            kindFoods(SysDict type, UserFood[] userFoods) {
                this.type = type;
                this.typeFoodList = userFoods;
            }
        }
        List<String> foodtypesID = new ArrayList<>();
        List<kindFoods> foodsList = new ArrayList<>();

        try {
//            List<Map<String, Object>> types = foodService.getAllType();

            List<SysDict> allTypes = sysDictService.selectAll();
//            for (int i = 0; i < types.size(); i++) {
//                foodtypesID.add(types.get(i).get("foodType").toString());
//            }

            for (int i = 0; i < allTypes.size();i++){
                foodtypesID.add(allTypes.get(i).getId());
            }
            for (int i = 0; i < foodtypesID.size(); i++) {
                System.out.println(foodtypesID.get(i));
                UserFood[] userFoods = foodService.getFoodsByType(foodtypesID.get(i));
                foodsList.add(new kindFoods(sysDictService.selectByPrimaryKey(foodtypesID.get(i)), userFoods));
            }

            return new AjaxMessage().Set(MsgType.Success, "获取食品列表成功", foodsList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "获取食品列表失败");
    }

    /**
     * @author zm
     * @param userId
     * @param foodTypeNameCn
     * @param sortNum
     * @return
     */
    @ApiOperation(value = "添加新的食品分类")
    @PostMapping("/addFoodType")
    @ResponseBody
    public Object addNewType(
            @ApiParam(name = "userId", value = "商家用户id", required = true, type = "String")
            @RequestParam(value = "userId")
                    String userId,
            @ApiParam(name = "foodTypeNameCn", value = "新食品种类名称(中文)", required = true, type = "String")
            @RequestParam(value = "foodTypeNameCn")
                    String foodTypeNameCn,
            /*@ApiParam(name = "foodTypeNameEn", value = "新食品种类名称(英文)", required = true, type = "String")
            @RequestParam(value = "foodTypeNameEn")
                    String foodTypeNameEn,*/
            @ApiParam(name = "sortNum", value = "分类排序号", required = true, type = "Integer")
            @RequestParam(value = "sortNum")
                    Integer sortNum
            /*@ApiParam(name = "remark", value = "食品分类的备注", required = false, type = "String")
            @RequestParam(value = "remark")
                    String remark*/
    ) {
        SysUser storeUser = userService.selectByPrimaryKey(userId);
        if(storeUser == null){
            return new AjaxMessage().Set(MsgType.Error, "商家用户不存在");
        }

        Date nowDate = new Date();
        SysDict newFoodType = new SysDict();
        newFoodType.setId("cc"+UUID.randomUUID().toString());
        newFoodType.setCreateUserId(userId);
        newFoodType.setModifyUserId(userId);
        newFoodType.setCreateDate(nowDate);
        newFoodType.setModifyDate(nowDate);
        newFoodType.setDictType("food_type");
        newFoodType.setSort(sortNum);
        newFoodType.setNameCn(foodTypeNameCn);
        /*newFoodType.setNameEn(foodTypeNameEn);
        if(remark != null && !remark.equals("")){
            newFoodType.setRemark(remark);
        }*/
        try {
            sysDictService.insertSelective(newFoodType);
            return new AjaxMessage().Set(MsgType.Success, "添加食品分类成功",newFoodType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "添加食品分类失败");
    }


    /**
     * @author zm
     * @param userId
     * @param foodName
     * @param foodPrice
     * @param foodType
     * @param foodMaterial
     * @return
     */
    @ApiOperation(value = "添加新食品")
    @PostMapping("/addNewFood")
    @ResponseBody
    public Object addNewFood(
            @ApiParam(name = "userId", value = "商家的用户id", required = true, type = "String")
            @RequestParam("userId")
                    String userId,
            @ApiParam(name = "foodName", value = "新食品名称", required = true, type = "String")
            @RequestParam("foodName")
                    String foodName,
            @ApiParam(name = "foodPrice", value = "新食品价格", required = true, type = "Double")
            @RequestParam("foodPrice")
                    Double foodPrice,
            @ApiParam(name = "foodType", value = "新食品的种类(字典项id)", required = true, type = "String")
            @RequestParam("foodType")
                    String foodType,
            @ApiParam(name = "foodMaterial", value = "新食品的原料", required = true, type = "String")
            @RequestParam("foodMaterial")
                    String foodMaterial

    ) {
        /*获取店家*/
        SysUser storeUser = userService.selectByPrimaryKey(userId);

        if (storeUser != null) {
            try {
                /*food表插入记录*/
                Date tmpDate = new Date();
                Food newFood = new Food();
                newFood.setId(UUID.randomUUID().toString());

                newFood.setFoodName(foodName);
                newFood.setFoodPrice(foodPrice);
                newFood.setFoodType(foodType);
                newFood.setFoodMaterial(foodMaterial);

                newFood.setCreateUserId(userId);
                newFood.setModifyUserId(userId);
                newFood.setCreateDate(tmpDate);
                newFood.setModifyDate(tmpDate);

                foodService.addNewFood(newFood);

                /*添加关联记录*/
                MapUserFood userFoodMap = new MapUserFood();
                userFoodMap.setId(UUID.randomUUID().toString());
                userFoodMap.setUserId(userId);
                userFoodMap.setFoodId(newFood.getId());
                userFoodMap.setCreateUserId(userId);
                userFoodMap.setModifyUserId(userId);
                userFoodMap.setCreateDate(tmpDate);
                userFoodMap.setModifyDate(tmpDate);

                mapUserFoodMapper.insertSelective(userFoodMap);
                return new AjaxMessage().Set(MsgType.Success, "新增Food成功", newFood);
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
            @RequestParam(value = "foodId")
                    String foodId
    ) {
        try {
            if (foodMapper.selectByFoodId(foodId) == null) {
                return new AjaxMessage().Set(MsgType.Success, "该食物不存在");
            }
            foodMapper.deleteByPrimaryKey(foodId);
            return new AjaxMessage().Set(MsgType.Success, "成功删除食物");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success, "删除食物失败");
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
            if (foodMapper.selectByFoodId(food.getId()) == null) {
                return new AjaxMessage().Set(MsgType.Success, "不存在此食物");
            }
            foodMapper.updateByPrimaryKeySelective(food);
            return new AjaxMessage().Set(MsgType.Success, "更新食物成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success, "更新食物失败");
    }

    @ApiOperation(value = "商家删除某一类的食物")
    @PostMapping("/deleteOneTypeFood")
    @ResponseBody
    public Object deleteOneTypeFood(
            @ApiParam(name = "foodType", value = "需要更新的食品", required = true, type = "String")
            @RequestParam(value = "foodType")
                    String foodType
    ) {
        try {
            foodMapper.deleteByFoodType(foodType);
            return new AjaxMessage().Set(MsgType.Success, "删除此类食物成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success, "删除此类食物失败");
    }

}
