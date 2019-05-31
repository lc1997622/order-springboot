package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.service.FoodService;
import com.ccorder.ordersystem.service.OrderService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zm
 * @description
 * @data 2019/5/16
 */
@Controller
@RequestMapping(value = "/order")
@Api(tags = "订单Api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private FoodService foodService;

    @ApiOperation(value = "获取用户历史订单")
    @PostMapping("/getMyOrders")
    @ResponseBody
    public Object getMyOrders(
            @ApiParam(name = "openId", value = "用户的openId", required = true, type = "String")
            @RequestParam("openId")
                    String openId
    ) {
        List<OrderTable> orderTableList = new ArrayList<>();

        try {
            orderTableList = orderService.getMyOrderList(openId);
            return new AjaxMessage().Set(MsgType.Success, "获取用户历史订单信息成功", orderTableList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error, "获取用户历史订单失败", null);
    }

    @ApiOperation(value = "获取订单详情")
    @PostMapping("/getOrderDetail")
    @ResponseBody
    public Object getOrderDetail(
            @ApiParam(name = "orderId", value = "订单主键id", required = true, type = "String")
            @RequestParam("orderId")
                    String orderId
    ){
        try{
            OrderTable orderNow = orderService.getOrderById(orderId);

            List<Food> foodList = foodService.getFoodsByOrderId(orderId);

            orderNow.setFoodList(foodList);

            return new AjaxMessage().Set(MsgType.Success,"获取订单详情成功",orderNow);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error,"获取订单详情失败",null);

    }

    /*@ApiOperation(value = "用户生成新的订单")
    @PostMapping("/generateNewOrder")
    @ResponseBody
    public Object generateNewOrder(
            @ApiParam(name = "userId", value = "用户id", required = true, type = "String")
            @RequestParam("userId")
                    String orderId
    )*/
}
