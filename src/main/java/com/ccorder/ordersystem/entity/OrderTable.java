package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class OrderTable {
    private String id;

    private String orderNum;

    /**
    * 字典项id
    */
    private String payMethod;

    private String address;

    private Double actualPayment;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}