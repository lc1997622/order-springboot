package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysDict {
    private String id;

    private String nameCn;

    private String nameEn;

    private Integer sort;

    /**
    * 对应字典类别表id
    */
    private String typeId;

    private String parentId;

    private String remark;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}