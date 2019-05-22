package com.ccorder.ordersystem.service;


import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zm
 * @description
 * @data 2019/5/16
 */
@Service
public class OrderService {

    @Autowired
    private MapUserOrderMapper mapUserOrderMapper;

    @Autowired
    private  OrderTableMapper orderMapper;

    @Autowired
    private OrderTableMapper orderTableMapper;

    @Autowired
    private MapOrderFoodMapper mapOrderFoodMapper;

    /** 添加一条订单记录*/
    public int addNewOrder(OrderTable orderTable){
        return orderTableMapper.insert(orderTable);
    }
    public int addNewOrderFood(MapOrderFood mapOrderFood){
        return mapOrderFoodMapper.insert(mapOrderFood);
    }

    /** 根据用户id返回其所有订单*/
    public List<OrderTable> getMyOrderList(String openId) {
        List<String> orderIdList = new ArrayList<>();
        List<OrderTable> orderList = new ArrayList<>();

        //首先获当前用户的所有订单id
        orderIdList = mapUserOrderMapper.selectByUserIdGetOrderId(openId);

        //根据orderId获取订单
        for (String orderId:orderIdList){
            orderList.add(orderMapper.selectByPrimaryKey(orderId));
        }

        return orderList;
    }

    /** 根据orderId返回订单详情*/
    public OrderTable getOrderById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
