package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Address {
    /**
     * 主键id
     */
    private String id;

    /**
     * 收货人姓名
     */
    private String receiverName;

    /**
     * 收货人电话号
     */
    private String receiverPhone;

    /**
     * 收货人性别:0是男1是女
     */
    private String receiverSex;

    /**
     * 地址名
     */
    private String addressName;

    /**
     * 门牌号
     */
    private String houseNumber;

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
     * 0是初始值，-1失效, 1是默认地址
     */
    private Integer status;
}