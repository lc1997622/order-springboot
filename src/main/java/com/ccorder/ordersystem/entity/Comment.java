package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Comment {
    private String id;

    private String orderId;

    /**
     * 商家对应的user_id
     */
    private String userId;

    private String content;

    private String createUserId;

    private Date createTime;

    private String modifyUserId;

    private Date modifyTime;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}