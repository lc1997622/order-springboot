package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapUserAddress {
    /**
    * 主键id
    */
    private String id;

    /**
    * 用户id
    */
    private String userId;

    /**
    * 地址id
    */
    private String addressId;

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