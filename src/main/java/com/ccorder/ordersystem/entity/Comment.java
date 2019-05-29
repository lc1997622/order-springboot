package com.ccorder.ordersystem.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Comment", description = "评论实体")
public class Comment {
    @ApiModelProperty(name = "id", value = "主键id", dataType = "String", example = "comment0001",
            required = true, allowEmptyValue = false)
    private String id;

    @ApiModelProperty(name = "orderId", value = "订单id", dataType = "String", example = "order0001",
            required = true, allowEmptyValue = false)
    private String orderId;

    @ApiModelProperty(name = "content", value = "评论内容", dataType = "String", example = "我是一条评论内容",
            required = false, allowEmptyValue = true)
    private String content;

    @ApiModelProperty(name = "score", value = "评论所属订单的评分", dataType = "Double", example = "100.5",
            required = false, allowEmptyValue = true)
    private Double score;

    @ApiModelProperty(name = "createUserId", value = "创建人id", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA",
            required = false, allowEmptyValue = true)
    private String createUserId;

    @ApiModelProperty(name = "createTime", value = "创建时间", dataType = "Date", example = "1999-01-26",
            required = false, allowEmptyValue = true)
    private Date createTime;

    @ApiModelProperty(name = "modifyUserId", value = "最终修改人id", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA",
            required = false, allowEmptyValue = true)
    private String modifyUserId;

    @ApiModelProperty(name = "modifyTime", value = "最终修改时间", dataType = "Date", example = "1999-01-27",
            required = false, allowEmptyValue = true)
    private Date modifyTime;

    @ApiModelProperty(name = "status", value = "评论状态(-1无效)", dataType = "Integer", example = "0",
            required = false, allowEmptyValue = true)
    private Integer status;
}