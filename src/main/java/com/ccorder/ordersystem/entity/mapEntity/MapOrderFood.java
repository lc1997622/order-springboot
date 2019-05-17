package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapOrderFood {
    /**
     * 主键id
     */
    private String id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 食品id
     */
    private String foodId;

    /**
     * 该订单中本食品数量
     */
    private Integer amount;

    /**
     * 该订单中本食品的评分
     */
    private Double score;

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