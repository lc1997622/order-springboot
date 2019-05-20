package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.SysRole;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
import com.ccorder.ordersystem.entity.mapEntity.MapUserRole;
import com.ccorder.ordersystem.mapper.FoodMapper;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.mapper.SysRoleMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserOrderMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserRoleMapper;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author htj
 * @description
 * @data 2019/5/18
 */
@Controller
@RequestMapping(value = "/order")
@Api(tags = "商家订单查询的API")
public class OrderInquiry {
    @Autowired
    private MapUserRoleMapper mapUserRoleMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private MapUserFoodMapper mapUserFoodMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private OrderTableMapper orderTableMapper;

    @Autowired
    private MapOrderFoodMapper mapOrderFoodMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private MapUserOrderMapper mapUserOrderMapper;



    private String orderNum;
    private List<String> foodList=null;
    private List<Integer> statusList=null;
    //状态与订单的对应
    String[] status=new String[4];
    {
        status[0]="未支付";
        status[1]="等待接单";
        status[2]="配送中";
        status[3]="已完成";
    }
    //总的订单查询
    @ApiOperation(value = "商家进行的总的订单的查询")
    @GetMapping("/inquiry")
    @ResponseBody
    public Object inquiry(
            @ApiParam(name = "userId", value = "微信用户的id", required = true,type = "String")
            @RequestParam
                    String userId
    ){
        @Data
        class AllOrder{
            List<String> orderStatus=null;
            List<List<Integer>> amountList=null;
            List<Float> paymentList=null;
            List<List<String>> foodNameList=null;
            AllOrder(List<String> orderStatus,List<List<Integer>> amountList,
                    List<Float> paymentList,List<List<String>> foodNameList){
                this.amountList=amountList;
                this.foodNameList=foodNameList;
                this.orderStatus=orderStatus;
                this.paymentList=paymentList;
            }
        }
        //查询数据库找到对象的role_id
        String roleId= mapUserRoleMapper.selectByUserId(userId);
        //通过role_id找到对应的code
        String code= sysRoleMapper.selectByRoleIdGetCode(roleId);
        //通过code判断是商家还是用户
//        if(!code.equals("1")){
//            return new AjaxMessage().Set(MsgType.Error,"你没有此权限");
//        }
        //通过商家的user_id可以得到order_id，通过order_id可以得到food_id，
        // 通过food_id得到食物的名称。
        //店名（user_id），订单状态（order_food_status），
        //数量（order_food_amount），food（food_name）总的价格（order_table）

        //先获得order_Id
        List<String> order_id_list=mapUserOrderMapper.selectByUserIdGetOrderId(userId);
        List<String> orderStatus=null;
        List<List<Integer>> amountList=null;
        List<Float> paymentList=null;
        List<List<String>> foodNameList=null;

        //获得对应的对应的订单状态
        for (String orderId : order_id_list) {
            //通过order_id获得订单状态(order_table)
            int state=orderTableMapper.getOrderStatus(orderId);
            orderStatus.add(status[state]);
            //通过order_id获得该订单的总的价格(order_table)
            paymentList.add(orderTableMapper.getOrderPayment(orderId));
            //通过order_id获得该订单中每件商品的数量商品数量(map_order_food)
            //先获得所有的food_Id，通过food_id以及
            List<String> foodIds=mapOrderFoodMapper.selectByOrderIdGetFoodId(orderId);
            //通过food_id获得数量以及名称
            List<String> nameList=new ArrayList<String>();
            List<Integer> amounts=new ArrayList<Integer>();
            for (String foodId : foodIds) {
                amounts.add(mapOrderFoodMapper.selectByFoodIdGetAmount(foodId));
                nameList.add(foodMapper.selectByUserIdFoodId(userId,foodId).getFoodName());
            }
            amountList.add(amounts);
            //获得该订单的食物列表(food)
            foodNameList.add(nameList);
        }
        AllOrder allOrder=new AllOrder(orderStatus,amountList,paymentList,foodNameList);
        try {
            return new AjaxMessage().Set(MsgType.Success,"查询成功",allOrder);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"查询失败");
    }

    //确切的订单查询
    @ApiOperation(value = "商家进行的总的订单的查询")
    @GetMapping("/theOrder")
    @ResponseBody
    public Object inquiry(
            @ApiParam(name = "userId", value = "微信用户的id", required = true,type = "String")
            @RequestParam
                    String userId,
            @ApiParam(name = "orderId", value = "订单的id", required = true,type = "String")
            @RequestParam
                    String orderId
    ){
        @Data
        class OneOrder{
            String status=null;
            List<String> foodName=null;
            List<Double> foodPrice=null;
            List<Integer> amountList=null;
            Date delivery_date=null;
            String receiveName=null;
            String address=null;
            String cellPhone=null;
            OneOrder(String status,List<String> foodName,List<Double> foodPrice
                    ,List<Integer> amountList,Date delivery_date,String receiveName
                    ,String address,String cellPhone){
                this.address=address;
                this.amountList=amountList;
                this.cellPhone=cellPhone;
                this.delivery_date=delivery_date;
                this.foodName=foodName;
                this.foodPrice=foodPrice;
                this.receiveName=receiveName;
                this.status=status;
            }
        }
        //获得该订单的状态
        int index=orderTableMapper.getOrderStatus(orderId);
        String orderStatus=status[index];
        //获得商品列表：该订单下 商品的数量，价格，名称
        //先获得该订单的foodid
        List<String> foodIdList=mapUserFoodMapper.selectByUserIdGetFoodId(userId);
        //通过food_id获得商品名称和价格
        List<String> foodName=new ArrayList<String>();
        List<Double> foodPrice=new ArrayList<Double>();
        List<Integer> amountList=new ArrayList<Integer>();
        for (String foodId : foodIdList) {
            Food food=foodMapper.selectByUserIdFoodId(userId, foodId);
            amountList.add(mapOrderFoodMapper.seletcByFoodIdGetAmount(foodId,userId));
            foodName.add(food.getFoodName());
            foodPrice.add(food.getFoodPrice());
        }
        //获取配送信息：用户（收），电话号码，收货地址，送达时间
        //通过Order_id获得收货地址
        OrderTable oneOrder=orderTableMapper.selectByPrimaryKey(orderId);
        String address=oneOrder.getAddress();
        //获取送达时间
        Date date=oneOrder.getDelivery_time_datetime();
        //通过create_user_Id获得用户姓名以及电话
        SysUser sysUser = sysUserMapper.selectByCreateUserIdGetUser(oneOrder.getCreateUserId());
        String userName=sysUser.getNickName();
        String phoneNum=sysUser.getTelephone();

        OneOrder theOrder=new OneOrder(orderStatus, foodName, foodPrice,amountList,
                date,userName,address,phoneNum);
        try {
            return new AjaxMessage().Set(MsgType.Success,"查询成功",theOrder);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"查询失败");
    }
}
