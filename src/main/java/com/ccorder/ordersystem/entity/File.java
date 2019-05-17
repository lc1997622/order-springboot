package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class File {
    /**
     * 主键id
     */
    private String id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件格式
     */
    private String fileType;

    /**
     * 文件存放路径
     */
    private String filePath;

    /**
     * 文件备注
     */
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