package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Comment {
    /**
     * 主键id
     */
    private String id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 对应的商家id
     */
    private String userId;

    /**
     * 评论内容(每个订单有一次评论机会)
     */
    private String content;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最终修改人id
     */
    private String modifyUserId;

    /**
     * 最终修改时间
     */
    private Date modifyTime;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}