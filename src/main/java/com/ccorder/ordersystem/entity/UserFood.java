package com.ccorder.ordersystem.entity;

import com.ccorder.ordersystem.entity.mapEntity.MapFile;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author ：LiChao
 * @date ：Created in 2019/5/17 23:25
 * @description：Food About User Client
 * @modified By：
 * @version: 1.0$
 */
@Data
public class UserFood {
    @ApiModelProperty(value = "ID",name = "ID",dataType = "String",example = "aswdawfevqe",
            required = true,allowEmptyValue = false)
    @Id
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

    @ApiModelProperty(value = "创建人ID",name = "createUserId",dataType = "String",example = "o258k0Zofn-pJJvLs6DzKRHwvkbA")
    private String createUserId;

    @ApiModelProperty(value = "创建时间",name = "createDate",dataType = "Data",example = "1999-01-26")
    private Date createDate;

    @ApiModelProperty(value = "最后修改人ID",name = "modifyUserId",dataType = "String",example = "o258k0Zofn-pJJvLs6DzKRHwvkbA")
    private String modifyUserId;

    @ApiModelProperty(value = "最后修改时间",name = "modifyDate",dataType = "Data",example = "1999-01-26")
    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    @ApiModelProperty(value = "ID",name = "ID",dataType = "Integer",example = "0",notes = "0是默认值，-1失效")
    private Integer status;

    private List<File> imges;
}
