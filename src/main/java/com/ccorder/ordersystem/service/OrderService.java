package com.ccorder.ordersystem.service;


import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.Food;
import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.entity.mapEntity.MapUserOrder;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserOrderMapper;
import com.ccorder.ordersystem.sys.dto.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zm
 * @description
 * @data 2019/5/16
 */
@Service
public class OrderService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private MapUserOrderMapper mapUserOrderMapper;

    @Autowired
    private OrderTableMapper orderMapper;

    @Autowired
    private OrderTableMapper orderTableMapper;

    @Autowired
    private MapOrderFoodMapper mapOrderFoodMapper;

    @Autowired
    private AddressMapper addressMapper;

    public int addNewOrderFood(MapOrderFood mapOrderFood) {
        return mapOrderFoodMapper.insert(mapOrderFood);
    }

    /**
     * 根据用户id返回其所有订单
     */
    public List<OrderTable> getMyOrderList(String openId) {
        List<String> orderIdList = new ArrayList<>();
        List<OrderTable> orderList = new ArrayList<>();

        //首先获当前用户的所有订单id
        orderIdList = mapUserOrderMapper.selectOrderIdByUserId(openId);

        //根据orderId获取订单
        for (String orderId : orderIdList) {
            orderList.add(orderMapper.selectByPrimaryKey(orderId));
        }

        return orderList;
    }

    /**
     * 根据orderId返回订单详情
     */
    public OrderTable getOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    /**
     * 用户下单成功
     */
    @Transactional
    public OrderTable addNewOrder(OrderTable newOrder) {
        String orderId = newOrder.getId();
        String userId = newOrder.getCreateUserId();
        Date dateNow = new Date();

        List<Food> foodList = newOrder.getFoodList();

        MapUserOrder userOrder = new MapUserOrder();
        MapUserOrder storeOrder = new MapUserOrder();

        /*用户的mapuserorder*/
        userOrder.setId(UUID.randomUUID().toString());
        userOrder.setUserId(userId);
        userOrder.setOrderId(orderId);
        userOrder.setCreateUserId(userId);
        userOrder.setModifyUserId(userId);
        userOrder.setCreateDate(dateNow);
        userOrder.setModifyDate(dateNow);
        /*商家的mapuserorder*/
        storeOrder.setId(UUID.randomUUID().toString());
        storeOrder.setUserId("store0001");
        storeOrder.setOrderId(orderId);
        storeOrder.setCreateUserId(userId);
        storeOrder.setModifyUserId(userId);
        storeOrder.setCreateDate(dateNow);
        storeOrder.setModifyDate(dateNow);
        mapUserOrderMapper.insertSelective(userOrder);
        mapUserOrderMapper.insertSelective(storeOrder);

        /*在mapUserFood表中插入记录*/
        for (Food tmpFood :
                newOrder.getFoodList()) {
            MapOrderFood mapOrderFood = new MapOrderFood();

            mapOrderFood.setId(UUID.randomUUID().toString());
            mapOrderFood.setOrderId(orderId);
            mapOrderFood.setFoodId(tmpFood.getId());
            mapOrderFood.setAmount(tmpFood.getFoodAmount());
            mapOrderFood.setCreateUserId(userId);
            mapOrderFood.setModifyUserId(userId);
            mapOrderFood.setCreateDate(dateNow);
            mapOrderFood.setModifyDate(dateNow);
            mapOrderFoodMapper.insertSelective(mapOrderFood);
        }

        /*1.设置订单号*/
        int orderAllCount = orderMapper.selectOrderAmountAll();
        String newOrderNum = "orderNum"+orderAllCount+1;
        newOrder.setOrderNum(newOrderNum);
        /*2.设置状态为已支付*/
        newOrder.setStatus(0);
        /*3.设置创建人、创建时间、修改人、修改时间*/
        newOrder.setCreateUserId(userId);
        newOrder.setCreateDate(dateNow);
        newOrder.setModifyUserId(userId);
        newOrder.setModifyDate(dateNow);
        /*4.在订单表插入新订单*/
        orderTableMapper.insertSelective(newOrder);
        /*5.用户余额扣款*/
        SysUser userNow = userMapper.selectByPrimaryKey(userId);
        userNow.setAccount(userNow.getAccount() - newOrder.getActualPayment());
        userMapper.updateByPrimaryKey(userNow);

        return orderTableMapper.selectByPrimaryKey(orderId);
    }
}
