package com.ccorder.ordersystem.entity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrderTable", description = "订单实体")
public class OrderTable {

    @ApiModelProperty(name = "id", value = "主键id", dataType = "String", example = "order0001",
            required = true, allowEmptyValue = false)
    private String id;

    @ApiModelProperty(name = "orderNum", value = "订单号", dataType = "String", example = "orderNum0001",
            required = true, allowEmptyValue = false)
    private String orderNum;

    @ApiModelProperty(name = "payMethod", value = "支付方式(字典项id)", dataType = "String", example = "dictNumId",
            required = false, allowEmptyValue = true)
    private String payMethod;

    @ApiModelProperty(name = "deliveryTime", value = "送达时间", dataType = "Date", example = "Wed May 22 16:05:32 CST 2019",
            required = false, allowEmptyValue = true)
    private Date deliveryTime;

    @ApiModelProperty(name = "address", value = "收货地址(不需要)", dataType = "String", example = "not need this ",
            required = false, allowEmptyValue = true)
    private String address;

    @ApiModelProperty(name = "actualPayment", value = "实际支付", dataType = "Double", example = "100.5",
            required = false, allowEmptyValue = true)
    private Double actualPayment;

    @ApiModelProperty(name = "foodList", value = "食物列表", dataType = "List<Food>", example = "无此输入项",
            required = false, allowEmptyValue = true)
    private List<Food> foodList;

    @ApiModelProperty(name = "createUserId", value = "创建人id", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA",
            required = false, allowEmptyValue = true)
    private String createUserId;

    @ApiModelProperty(name = "createDate", value = "创建时间", dataType = "Date", example = "Wed May 22 16:05:32 CST 2019",
            required = false, allowEmptyValue = true)
    private Date createDate;

    @ApiModelProperty(name = "modifyUserId", value = "最终修改人id", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA",
            required = false, allowEmptyValue = true)
    private String modifyUserId;

    @ApiModelProperty(name = "modifyDate", value = "最终修改时间", dataType = "Date", example = "Wed May 22 16:05:32 CST 2019",
            required = false, allowEmptyValue = true)
    private Date modifyDate;

    @ApiModelProperty(name = "status", value = "订单状态(枚举项)", dataType = "Integer", example = "0",
            required = true, allowEmptyValue = false)
    private Integer status;
}