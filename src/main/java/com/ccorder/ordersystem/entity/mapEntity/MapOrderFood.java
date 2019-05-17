package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapOrderFood {
    private String id;

    private String orderId;

    private String foodId;

    private Double score;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    private Integer status;
}