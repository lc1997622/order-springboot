package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysRole {
    /**
     * 主键id
     */
    private String id;

    /**
     * 角色code
     */
    private String code;

    /**
     * 排序
     */
    private String sort;

    /**
     * 角色名
     */
    private String name;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 修改人id
     */
    private String modifyUserId;

    /**
     * 修改时间
     */
    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}