package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.annotation.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author htj
 * @description
 * @data 2019/5/12
 */

@Controller
@RequestMapping(value = "/businessOrder")
@Api(tags = "商家订单操作的API")
public class BusinessOrderController {
    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private OrderTableMapper orderTableMapper;

    @Autowired
    private MapOrderFoodMapper mapOrderFoodMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private AddressMapper addressMapper;

    //商家对订单状态的修改
    @ApiOperation(value = "修改订单状态")
    @PostMapping("/changeOrderState")
    @ResponseBody
    public Object changeOrderStatus(
            @ApiParam(name = "orderId", value = "订单主键id", required = true,type = "String")
            @RequestParam(value = "orderId")
                    String orderId,
            @ApiParam(name = "status", value = "订单状态号", required = true,type = "Integer")
            @RequestParam(value = "status")
                    Integer status
    ){
        /*如果是修改为订单已经完成，那么商家的account应该增加收入*/
        if(status == 4){
            OrderTable tmpOrder = orderTableMapper.selectByPrimaryKey(orderId);
            SysUser storeUser = sysUserMapper.selectByPrimaryKey("store0001");
            storeUser.setAccount(storeUser.getAccount() + tmpOrder.getActualPayment());
            sysUserMapper.updateByPrimaryKey(storeUser);
        }

        orderTableMapper.updateOrderstate(orderId, status);
        return new AjaxMessage().Set(MsgType.Success,"订单状态修改成功");
    }

    //商家的历史订单查询
    @ApiOperation(value = "商家历史订单订单的查询")
    @PostMapping("/historyInquiry")
    @ResponseBody
    public Object inquiry(){
        @Data
        class OrderAll{
            OrderTable[] orderTables=null;
            List<Address> addresses=null;
            OrderAll(){
                this.addresses=new ArrayList<Address>();
            }
        }
        try{
            OrderAll orderall=new OrderAll();
            orderall.orderTables=orderTableMapper.getBusinessAllOrder();
            System.out.println(orderall.orderTables[0]);
            for (OrderTable orderTable : orderall.orderTables) {
                orderall.addresses.add(addressMapper.selectByAddressIdGetAddress(orderTable.getAddress()));
            }
            System.out.println(orderall.addresses.get(0));
            return new AjaxMessage().Set(MsgType.Success,
                    "成功查询商家历史订单",orderall);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"历史订单查询失败");
    }

    //确切的订单查询
    @ApiOperation(value = "商家对某一订单的详细信息查询")
    @PostMapping("/inquiryOneOrder")
    @ResponseBody
    public Object inquiry(
            @ApiParam(name = "orderId", value = "订单的id", required = true,type = "String")
            @RequestParam(value = "orderId")
                    String orderId
    ){
        @Data
        class TheOrder{
            List<String> foodNames=null;
            List<Double> foodPrices=null;
            List<Integer> foodAmounts=null;
            OrderTable oneOrder=null;
            double shipFee=0;
            Address address=null;
        }
        try {
            List<String> foodNames=new ArrayList<String>();
            List<Double> foodPrices=new ArrayList<Double>();
            List<Integer> foodAmounts=new ArrayList<Integer>();
            //先找到该订单
            OrderTable theOrder=orderTableMapper.selectByPrimaryKey(orderId);
            List<String> foodIdList=mapOrderFoodMapper.selectByOrderIdGetFoodId(orderId);
            //获取地址
            System.out.println(theOrder.getAddress());

            Address address=addressMapper.selectByAddressIdGetAddress(theOrder.getAddress());
            System.out.println(address);
            for(String foodId:foodIdList){
                //返回该顶单的食物名称（food）
                foodNames.add(foodMapper.selectByFoodIdGetFoodName(foodId));
                //返回该订单的食物价格（food）
                foodPrices.add(foodMapper.selectByFoodIdGetFoodPrice(foodId));
                //返回该订单的食物数量（maporderfood）
                foodAmounts.add(mapOrderFoodMapper.selectByFoodIdGetAmount(foodId,orderId));
            }
            TheOrder one=new TheOrder();
            one.setOneOrder(theOrder);
            one.setFoodNames(foodNames);
            one.setFoodPrices(foodPrices);
            one.setFoodAmounts(foodAmounts);
            one.setAddress(address);
            one.setShipFee(sysUserMapper.selectByStatusGetShipFee());
            return new AjaxMessage().Set(MsgType.Success,
                    "查询该订单成功",one);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"查询该订单失败");
    }

   /* @ApiOperation(value = "商家——新订单的插入")
    @PostMapping("/addNewOrder")
    @ResponseBody
    public Object addOrder(
            @ApiParam(name = "oneOrder", value = "新的order的订单", required = true,type = "OrderTable")
            @RequestBody
                    OrderTable oneOrder,
            @ApiParam(name = "foodIds", value = "该订单的foodid列表", required = true,type = "List<String>")
            @RequestParam(value = "foodIds")
                    List<String> foodIds,
            @ApiParam(name = "foodAmounts", value = "该订单的每种食物数量列表", required = true,type = "List<Integer>")
            @RequestParam(value = "foodAmounts")
                    List<Integer> foodAmounts,
            @ApiParam(name = "foodScores", value = "该订单的每种食物的评分", required = true,type = "List<Double>")
            @RequestParam(value = "foodScores")
                    List<Double> foodScores
    ){
        OrderTable newOrder=new OrderTable();
        Date date=new Date();
        newOrder.setId(UUID.randomUUID().toString());
        newOrder.setOrderNum(oneOrder.getOrderNum());
        newOrder.setDeliveryTime(oneOrder.getDeliveryTime());
        newOrder.setActualPayment(oneOrder.getActualPayment());
        newOrder.setPayMethod(oneOrder.getPayMethod());
        newOrder.setCreateUserId(oneOrder.getCreateUserId());
        newOrder.setModifyUserId(oneOrder.getModifyUserId());
        newOrder.setScore(newOrder.getScore());
        newOrder.setCreateDate(date);
        newOrder.setModifyDate(date);
        newOrder.setStatus(oneOrder.getStatus());
        newOrder.setAddress(oneOrder.getAddress());
        try {
            orderTableMapper.insertSelective(newOrder);
            MapOrderFood  oneMapOrderFood=new MapOrderFood();
            oneMapOrderFood.setModifyDate(date);
            oneMapOrderFood.setOrderId(newOrder.getId());
            oneMapOrderFood.setCreateDate(date);
            oneMapOrderFood.setCreateUserId(newOrder.getCreateUserId());
            oneMapOrderFood.setModifyUserId(newOrder.getModifyUserId());
            oneMapOrderFood.setStatus(0);
            for(int i=0;i<foodIds.size();i++){
                oneMapOrderFood.setFoodId(foodIds.get(i));
                oneMapOrderFood.setId(UUID.randomUUID().toString());
                oneMapOrderFood.setAmount(foodAmounts.get(i));
                oneMapOrderFood.setScore(foodScores.get(i));
                mapOrderFoodMapper.insertSelective(oneMapOrderFood);
            }
            return new AjaxMessage().Set(MsgType.Success,"成功添加订单");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "添加订单失败");
    }*/
}
