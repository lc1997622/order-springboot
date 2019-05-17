package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Food {
    private String id;

    private String foodName;

    private Double foodPrice;

    /**
     * 对应字典项的id
     */
    private String foodType;

    private String foodMaterial;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;

}