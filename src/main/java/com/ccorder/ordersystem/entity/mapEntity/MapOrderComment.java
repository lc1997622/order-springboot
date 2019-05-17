package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapOrderComment {
    /**
     * 主键id
     */
    private String id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 评论id
     */
    private String commentId;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最终修改人id
     */
    private String modifyUserId;

    /**
     * 最终修改时间
     */
    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}