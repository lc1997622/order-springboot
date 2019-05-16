package com.ccorder.ordersystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value="com.ccorder.ordersystem.entity.MapUserOrder")
@Data
public class MapUserOrder {
    @ApiModelProperty(value="null")
    private String id;

    @ApiModelProperty(value="null")
    private String userId;

    @ApiModelProperty(value="null")
    private String orderId;

    @ApiModelProperty(value="null")
    private String createUserId;

    @ApiModelProperty(value="null")
    private Date createDate;

    @ApiModelProperty(value="null")
    private String modifyUserId;

    @ApiModelProperty(value="null")
    private Date modifyDate;

    /**
    * 0是默认值，-1失效
    */
    @ApiModelProperty(value="0是默认值，-1失效")
    private Integer status;
}