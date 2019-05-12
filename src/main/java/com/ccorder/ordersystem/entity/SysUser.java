package com.ccorder.ordersystem.entity;

import java.util.Date;
import lombok.Data;

@Data
public class SysUser {
    private String id;

    private String username;

    private String password;

    private String realName;

    private String nickName;

    /**
     * 0是初始值(未设置)，1是男，2是女
     */
    private Integer sex;

    private String telephone;

    private String email;

    private Date birthday;

    private String createUserId;

    private Date createTime;

    private String modifyUserId;

    private Date modifyTime;

    /**
     * 0是默认值，-1失效
     */
    private Integer status;
}