package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.OrderTable;

public interface OrderTableMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderTable record);

    int insertSelective(OrderTable record);

    OrderTable selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderTable record);

    int updateByPrimaryKey(OrderTable record);

    Integer getOrderStatus(String orderId);

    Float getOrderPayment(String orderId);
}