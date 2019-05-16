package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class MapUserFood {
    private String id;

    private String userId;

    private String foodId;

    private Double discount;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}