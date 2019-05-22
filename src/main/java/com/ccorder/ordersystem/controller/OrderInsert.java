package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author htj
 * @description
 * @data 2019/5/18
 */
@Controller
@RequestMapping(value="/order")
@Api(tags = "订单插入")
public class OrderInsert {

    @Autowired
    private OrderTableMapper orderTableMapper ;

    @Autowired
    private MapOrderFoodMapper mapOrderFoodMapper;

    @ApiOperation(value = "产生新的订单时向数据库的表中添加新的订单")
    @PostMapping("/addOrder")
    @ResponseBody
    public Object addOrder(
            @ApiParam(name = "openId", value = "微信用户的id", required = true,type = "String")
            @RequestParam
                    String openId,
            @ApiParam(name = "payMethod", value = "支付方式", required = true, type = "String")
            @RequestParam
                    String payMethod,
            @ApiParam(name = "address", value = "送货地址", required = true, type = "String")
            @RequestParam
                    String address,
            @ApiParam(name = "Money", value = "实际支付的金额", required = true, type = "Double")
            @RequestParam
                    Double Money,
            @ApiParam(name = "modifyUserId", value = "更改订单的用户Id", required = true, type = "String")
            @RequestParam
                    String modifyUserId,
            @ApiParam(name = "food_id", value = "商品的id", required = true, type = "List<String>")
            @RequestParam
                    List<String> food_id,
            @ApiParam(name = "amount", value = "数量", required = true, type = "Integer")
            @RequestParam
                    Integer amount,
            @ApiParam(name = "score",  value = "评分", required = true, type = "double")
            @RequestParam
                    double score,
            @ApiParam(name = "delivery_time_datetime",  value = "送达时间", required = true, type = "Date")
            @RequestParam
                    Date delivery_time_datetime
    ){
        OrderTable newOrder=new OrderTable();
        Date date=new Date();
        //设置主键
        newOrder.setId(UUID.randomUUID().toString());
        //设置订单编号
        newOrder.setOrderNum(UUID.randomUUID().toString());
        //设置支付方式
        newOrder.setPayMethod(payMethod);
        //设置收货地址
        newOrder.setAddress(address);
        //设置创建人id
        newOrder.setCreateUserId(openId);
        //设置实际支付金额
        newOrder.setActualPayment(Money);
        //设置创建日期
        newOrder.setCreateDate(date);
        //设置最终修改人的id
        newOrder.setModifyUserId(modifyUserId);
        //设置最后的修改日期
        newOrder.setModifyDate(date);
        //设置状态
        newOrder.setStatus(0);
        //设置送达时间
        newOrder.setDeliveryTime(delivery_time_datetime);

        MapOrderFood mapOrderFood=new MapOrderFood();
        //添加主键id
        mapOrderFood.setId(UUID.randomUUID().toString());
        //添加订单id
        mapOrderFood.setOrderId(newOrder.getId());

        //添加食品数量
        mapOrderFood.setAmount(amount);
        //添加本食品的评分
        mapOrderFood.setScore(score);
        //添加创建人的id
        mapOrderFood.setCreateUserId(openId);
        //添加创建时间
        mapOrderFood.setCreateDate(date);
        //添加最终修改人的id
        mapOrderFood.setModifyUserId(modifyUserId);
        //添加最终的修改时间
        mapOrderFood.setModifyDate(date);
        //设置状态
        mapOrderFood.setStatus(0);
        try {
            orderTableMapper.insert(newOrder);
            for (String s : food_id) {
                mapOrderFood.setFoodId(s);
                mapOrderFoodMapper.insert(mapOrderFood);
            }
            return new AjaxMessage().Set(MsgType.Success,"成功添加订单");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "添加订单失败");
    }
}
