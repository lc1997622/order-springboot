package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysRole {
    private String id;

    private String code;

    private String sort;

    private String name;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}