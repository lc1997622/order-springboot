package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapFile {
    private String id;

    /**
    * 对应字典项的id
    */
    private String foodType;

    private String 对象id;

    private String objectType;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}