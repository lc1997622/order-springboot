package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class OrderTable {
    /**
     * 主键id
     */
    private String id;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 支付方式(字典项id)
     */
    private String payMethod;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 实际支付
     */
    private Double actualPayment;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最终修改人id
     */
    private String modifyUserId;

    /**
     * 最终修改时间
     */
    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;

    /*
    * delivery_time_datetime表示送达的时间
    */
    private Date delivery_time_datetime;
}