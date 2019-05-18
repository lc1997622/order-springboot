package com.ccorder.ordersystem.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "File",description = "文件实体")
public class File {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "ID",name = "id",dataType = "String",example = "0001",
            required = true,allowEmptyValue = false)
    private String id;

    /**
     * 文件名
     */
    @ApiModelProperty(value = "文件名",name = "fileName",dataType = "String",example = "food.jpg",
            required = true,allowEmptyValue = false)
    private String fileName;

    /**
     * 文件格式
     */
    @ApiModelProperty(value = "文件类型",name = "fileType",dataType = "String",example = "jpg")
    private String fileType;

    /**
     * 文件存放路径
     */
    @ApiModelProperty(value = "文件路径",name = "filePath",dataType = "String",example = "")
    private String filePath;

    /**
     * 文件备注
     */
    @ApiModelProperty(value = "文件备注",name = "fileRemark",dataType = "String",example = "")
    private String fileRemark;

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