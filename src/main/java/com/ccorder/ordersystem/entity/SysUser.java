package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysUser {
    /**
     * 主键id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 0是初始值(未设置)，1是男，2是女
     */
    private Integer sex;

    /**
     * 电话号
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 创建人id
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最终修改人id
     */
    private String modifyUserId;

    /**
     * 最终修改时间
     */
    private Date modifyTime;

    /**
     * 0是默认值，-1失效，1是店家
     */
    private Integer status;

    /*
    *配送起始时间
     */
    private Date startTime;

    /*
    *配送结束时间
     */
    private Date endTime;

    /**
     * 商家的自我介绍
     */
    private String businessIntroduction;

    /**
     * 商家的评星
     */
    private Integer starsNum;
}