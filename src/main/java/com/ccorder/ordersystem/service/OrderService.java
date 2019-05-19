package com.ccorder.ordersystem.service;


import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapOrderFood;
import com.ccorder.ordersystem.mapper.mapMapper.MapOrderFoodMapper;

/**
 * @author zm
 * @description
 * @data 2019/5/16
 */
public class OrderService {
    private OrderTableMapper orderTableMapper;
    private MapOrderFoodMapper mapOrderFoodMapper;
    //添加一条订单记录
    public int addNewOrder(OrderTable orderTable){
        return orderTableMapper.insert(orderTable);
    }
    public int addNewOrderFood(MapOrderFood mapOrderFood){
        return mapOrderFoodMapper.insert(mapOrderFood);
    }
}
