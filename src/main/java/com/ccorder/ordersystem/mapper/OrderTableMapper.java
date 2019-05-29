package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.OrderTable;

import java.util.List;

public interface OrderTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderTable record);

    int insertSelective(OrderTable record);

    OrderTable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderTable record);

    int updateByPrimaryKey(OrderTable record);

    Integer getOrderStatus(String orderId);

    Float getOrderPayment(String orderId);

    void updateOrderstate(String orderId,int state);

    /** 根据userId查询订单列表*/
    List<OrderTable> selectByUserId(String userId);
}