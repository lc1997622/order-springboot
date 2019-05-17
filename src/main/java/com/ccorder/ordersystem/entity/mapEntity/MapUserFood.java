package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapUserFood {
    /**
     * 主键id
     */
    private String id;

    /**
     * 用户id(店家)
     */
    private String userId;

    /**
     * 食品id
     */
    private String foodId;

    /**
     * 食品折扣，范围(0,1)
     */
    private Double discount;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后修改人id
     */
    private String modifyUserId;

    /**
     * 最后修改时间
     */
    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}