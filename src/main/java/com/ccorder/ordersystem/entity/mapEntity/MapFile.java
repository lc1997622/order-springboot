package com.ccorder.ordersystem.entity.mapEntity;

import java.util.Date;
import lombok.Data;

@Data
public class MapFile {
    /**
     * 主键ID
     */
    private String id;

    /**
     * file表主键
     */
    private String fileId;

    /**
     * 对象的主键ID
     */
    private String objectId;

    /**
     * 文件类型(对应字典项的id)
     */
    private String foodType;

    /**
     * 对象类型(对应字典项id)
     */
    private String objectType;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 最后修改人id
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