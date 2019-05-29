package com.ccorder.ordersystem.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zm
 */
@Data
@ApiModel(value = "Food", description = "食品实体")
public class Food {
    @ApiModelProperty(value = "主键id", name = "id", dataType = "String", example = "aswdawfevqe",
            required = true, allowEmptyValue = false)
    private String id;

    @ApiModelProperty(value = "食物名称", name = "foodName", dataType = "String", example = "酸菜鱼",
            required = true, allowEmptyValue = false)
    private String foodName;

    @ApiModelProperty(value = "食品价格", name = "foodPrice", dataType = "Double", example = "100",
            required = true, allowEmptyValue = false)
    private Double foodPrice;

    /**
     * 对应字典项的id
     */
    @ApiModelProperty(value = "食物类别", name = "foodType", dataType = "String", example = "0001", notes = "对应字典项的id",
            required = true, allowEmptyValue = false)
    private String foodType;

    @ApiModelProperty(value = "食物原料", name = "foodMaterial", dataType = "String", example = "清江鱼 酸菜",
            required = false, allowEmptyValue = true)
    private String foodMaterial;

    /** 订单查询的时候用到，其余时候用不上*/
    @ApiModelProperty(value = "食物数量", name = "foodAmount", dataType = "Integer", example = "10",
            required = false, allowEmptyValue = true)
    private Integer foodAmount;

    @ApiModelProperty(value = "创建人ID", name = "createUserId", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA")
    private String createUserId;

    @ApiModelProperty(value = "创建时间", name = "createDate", dataType = "Data", example = "1999-01-26")
    private Date createDate;

    @ApiModelProperty(value = "最后修改人ID", name = "modifyUserId", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA")
    private String modifyUserId;

    @ApiModelProperty(value = "最后修改时间", name = "modifyDate", dataType = "Data", example = "1999-01-26")
    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    @ApiModelProperty(value = "状态", name = "status", dataType = "Integer", example = "0", notes = "0是默认值，-1失效")
    private Integer status;

}