package com.ccorder.ordersystem.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author zm
 */
@Data
@ApiModel(value = "SysDict",description = "系统字典项实体")
public class SysDict {
    @ApiModelProperty(name = "ID",value = "ID",dataType = "String",example = "aswdawfevqe",
            required = true,allowEmptyValue = false)
    private String id;

    @ApiModelProperty(name = "nameCn",value = "字典项中文名",dataType = "String",example = "食物类别",
            required = false,allowEmptyValue = true)
    private String nameCn;

    @ApiModelProperty(name = "nameEn",value = "字典项英文名",dataType = "String",example = "foodType",
            required = false,allowEmptyValue = true)
    private String nameEn;

    @ApiModelProperty(name = "sort",value = "字典项排序数",dataType = "String",example = "aswdawfevqe",notes = "默认是0",
            required = false,allowEmptyValue = false)
    private Integer sort;

    /**
    * 对应字典类别表id
    */
    @ApiModelProperty(name = "typeId",value = "字典项类别ID",dataType = "String",example = "aswdawfevqe",
            required = true,allowEmptyValue = false)
    private String typeId;

    @ApiModelProperty(name = "parentId",value = "父字典项ID",dataType = "String",example = "aswdawfevqe",
            required = true,allowEmptyValue = false)
    private String parentId;

    @ApiModelProperty(name = "remark",value = "注释",dataType = "String",example = "我是一段注释",
            required = true,allowEmptyValue = false)
    private String remark;

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
}