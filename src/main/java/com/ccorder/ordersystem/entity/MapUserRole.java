package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class MapUserRole {
    private String id;

    private String userId;

    private String roleId;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}