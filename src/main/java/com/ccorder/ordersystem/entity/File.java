package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class File {
    private String id;

    private String fileName;

    private String fileType;

    /**
     * 对应字典项的id
     */
    private String filePath;

    private String fileRemark;

    private String createUserId;

    private Date createDate;

    private String modifyUserId;

    private Date modifyDate;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}