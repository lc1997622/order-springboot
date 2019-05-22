package com.ccorder.ordersystem.sys.dto;

/**
 * @author zm
 * @description 订单状态枚举类
 * @data 2019/5/22
 */
public enum OrderType {
    Deleted(-1,"已删除"),
    UnPayed(0,"未支付"),
    Received(1,"已接单"),
    Delivering(2,"配送中"),
    Delivered(3,"已送达"),
    Finished(4,"已完成");

    private int code;

    private String msgName;

    OrderType(){}
    OrderType(int code,String msgName)
    {
        this.code=code;
        this.msgName=msgName;
    }
}
