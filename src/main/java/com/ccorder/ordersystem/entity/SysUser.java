package com.ccorder.ordersystem.entity;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zm
 */
@Data
@ApiModel(value = "SysUser", description = "用户实体(商家+用户都有)")
public class SysUser {
    @ApiModelProperty(name = "id", value = "主键id", dataType = "String", example = "store0001",
            required = true, allowEmptyValue = false)
    private String id;

    @ApiModelProperty(name = "username", value = "用户名", dataType = "String", example = "store0001",
            required = true, allowEmptyValue = false)
    private String username;

    @ApiModelProperty(name = "password", value = "密码", dataType = "String", example = "passwordxxxxx",
            required = false, allowEmptyValue = true)
    private String password;

    @ApiModelProperty(name = "account", value = "账户余额", dataType = "Double", example = "120",notes = "设置默认值",
            required = false, allowEmptyValue = true)
    private Double account;

    @ApiModelProperty(name = "realName", value = "真实姓名", dataType = "String", example = "realnamexxx",
            required = false, allowEmptyValue = true)
    private String realName;

    @ApiModelProperty(name = "nickName", value = "用户昵称", dataType = "String", example = "nicknamexxx",
            required = false, allowEmptyValue = true)
    private String nickName;

    @ApiModelProperty(name = "sex", value = "性别", dataType = "Integer", example = "1",
            notes = "(0是初始值(未设置)，1是男，2是女)",
            required = false, allowEmptyValue = true)
    private Integer sex;

    @ApiModelProperty(name = "telephone", value = "电话", dataType = "String", example = "188xxxxxxxx",
            required = false, allowEmptyValue = true)
    private String telephone;

    @ApiModelProperty(name = "email", value = "邮箱", dataType = "String", example = "xxxx@qq.com",
            required = false, allowEmptyValue = true)
    private String email;

    @ApiModelProperty(name = "birthday", value = "生日", dataType = "Date", example = "1980-01-01",
            required = false, allowEmptyValue = true)
    private Date birthday;

    /**
     * 门店介绍：商家特有
     */
    @ApiModelProperty(name = "businessIntroduction", value = "门店介绍", dataType = "String", example = "我是一段介绍",
            required = false, allowEmptyValue = true)
    private String businessIntroduction;

    /**
     * 店铺评星(0-5整数)
     */
    @ApiModelProperty(name = "starsNum", value = "店铺评星", dataType = "Integer", example = "4",notes = "0-5的整数",
            required = false, allowEmptyValue = true)
    private Integer starsNum;

    @ApiModelProperty(name = "shipFee", value = "配送费", dataType = "Double", example = "4.5",notes = "商家特有",
            required = false, allowEmptyValue = true)
    private Double shipFee;

    @ApiModelProperty(name = "startTime", value = "配送开始时间", dataType = "Date", example = "193-09-78 12:00",notes = "要是data格式",
            required = false, allowEmptyValue = true)
    private Date startTime;

    @ApiModelProperty(name = "endTime", value = "配送结束时间", dataType = "Date", example = "193-09-78 23:00",notes = "要是data格式",
            required = false, allowEmptyValue = true)
    private Date endTime;

    /**
     * 商家地址
     * */
    private Address storeAddress;

    /**
     * 用户地址列表
     * */
    private List<Address> myAddressList;

    @ApiModelProperty(value = "创建人ID", name = "createUserId", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA")
    private String createUserId;

    @ApiModelProperty(value = "创建时间", name = "createDate", dataType = "Data", example = "1999-01-26")
    private Date createTime;

    @ApiModelProperty(value = "最后修改人ID", name = "modifyUserId", dataType = "String", example = "o258k0Zofn-pJJvLs6DzKRHwvkbA")
    private String modifyUserId;

    @ApiModelProperty(value = "最后修改时间", name = "modifyDate", dataType = "Data", example = "1999-01-26")
    private Date modifyTime;

    @ApiModelProperty(value = "ID", name = "ID", dataType = "Integer", example = "0", notes = "0是默认值，-1失效，1 是商家营业中，2是商家休息中")
    private Integer status;
}