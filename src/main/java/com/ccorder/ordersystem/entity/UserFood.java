package com.ccorder.ordersystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author ：LiChao
 * @date ：Created in 2019/5/17 23:25
 * @description：Food About User Client
 * @modified By：
 * @version: 1.0$
 */
@Data
@ApiModel(value = "UserFood",description = "客户端食品实体")
public class UserFood {
    @ApiModelProperty(value = "ID",name = "ID",dataType = "String",example = "aswdawfevqe",
            required = true,allowEmptyValue = false)
    private String id;

    @ApiModelProperty(value = "食物名称",name = "foodName",dataType = "String",example = "酸菜鱼",
            required = true,allowEmptyValue = false)
    private String foodName;

    @ApiModelProperty(value = "食品价格",name = "foodPrice",dataType = "Double",example = "100",
            required = true,allowEmptyValue = false)
    private Double foodPrice;

    /**
     * 对应字典项的id
     */
    @ApiModelProperty(value = "食物类别",name = "foodType",dataType = "String",example = "0001", notes = "对应字典项的id",
            required = true,allowEmptyValue = false)
    private String foodType;

    @ApiModelProperty(value = "食物原料",name = "foodMaterial",dataType = "String",example = "清江鱼 酸菜",
            required = false,allowEmptyValue = true)
    private String foodMaterial;

    @ApiModelProperty(value = "食物图片",name = "imges",dataType = "List")
    private List<File> imges;
}
