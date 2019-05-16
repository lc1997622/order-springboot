package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapOrderComment {
    private String id;

    private String orderId;

    private String commentId;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}