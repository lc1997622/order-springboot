package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysDict {
    /**
     * 主键id
     */
    private String id;

    /**
     * 中文名
     */
    private String nameCn;

    /**
     * 英文名
     */
    private String nameEn;

    /**
     * 排序序号
     */
    private Integer sort;

    /**
     * 父字典项id
     */
    private String parentId;

    /**
     * 备注
     */
    private String remark;

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