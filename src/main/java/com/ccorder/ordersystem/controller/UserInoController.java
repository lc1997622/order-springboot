package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.*;
import com.ccorder.ordersystem.entity.mapEntity.MapUserAddress;
import com.ccorder.ordersystem.entity.mapEntity.MapUserRole;
import com.ccorder.ordersystem.service.AddressService;
import com.ccorder.ordersystem.service.MapUserAddressService;
import com.ccorder.ordersystem.service.SysRoleService;
import com.ccorder.ordersystem.service.SysUserService;
import com.ccorder.ordersystem.service.mapService.MapUserRoleService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ：LiChao
 * @date ：Created in 2019/5/18 13:32
 * @description：用户端个人中心
 * @modified By：
 * @version: 1.0$
 */
@Controller
@Api(tags = "用户API")
@RequestMapping(value = "/user")
public class UserInoController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    MapUserRoleService mapUserRoleService;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    MapUserAddressService mapUserAddressService;

    @Autowired
    AddressService addressService;

    @ApiOperation(value = "获取用户信息")
    @PostMapping("getUserInfo")
    @ResponseBody
    public Object getUserInfo(
            @ApiParam(name = "userId", value = "用户的微信ID", required = true, type = "String")
            @RequestParam("userId")
                    String userId
    ) {
        try {
            ClientUser clientUser = sysUserService.getClientUserInfo(userId);
            if (clientUser == null) {
                return new AjaxMessage().Set(MsgType.Error, "用户不存在");
            }
            return new AjaxMessage().Set(MsgType.Success, "获取用户信息成功", clientUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "获取用户信息失败");
    }

    @ApiOperation(value = "插入新用户")
    @PostMapping("addNewUser")
    @ResponseBody
    protected Object addNewUser(
            @ApiParam(name = "userId", value = "用户Id",required = true,type = "String")
            @RequestParam(value = "userId")
                    String userId,
            @ApiParam(name = "nickname", value = "用户昵称",required = true, type = "String")
            @RequestParam(value = "nickname")
                    String nickname,
            @ApiParam(name = "sex", value = "用户性别",required = true, type = "Integer")
            @RequestParam(value = "sex")
                    Integer sex
            ) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setNickName(nickname);
        sysUser.setSex(sex);
        sysUser.setAccount(100.0);
        sysUser.setUsername(nickname);
        Date tmpDate = new Date();
        sysUser.setCreateTime(tmpDate);
        sysUser.setModifyTime(tmpDate);

        try {
            sysUserService.insert(sysUser);
            return new AjaxMessage().Set(MsgType.Success, "插入新用户成功");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error, "插入新用户失败");
    }

    @ApiOperation(value = "获取用户地址")
    @PostMapping("getUserAddress")
    @ResponseBody
    protected Object getUserAddress(
            @ApiParam(name = "userId", value = "用户微信ID", required = true, type = "String")
            @RequestParam(value = "userId")
                    String userId
    ) {
        List<Address> addresses = new ArrayList<>();
        try {
            List<MapUserAddress> mapUserAddresses = mapUserAddressService.selectByUserId(userId);
            for (MapUserAddress userAddress : mapUserAddresses) {
                Address address = addressService.selectByPrimaryKey(userAddress.getAddressId());
                if (address != null) {
                    addresses.add(address);
                }
            }
            return new AjaxMessage().Set(MsgType.Success, "获取用户地址成功", addresses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "获取用户地址失败");
    }


    /**
     * @param userId
     * @param recName
     * @param recSex
     * @param recPhone
     * @param addressName
     * @param houseNum
     * @return
     * @author zm
     */
    @ApiOperation(value = "加入用户地址")
    @PostMapping("addUserAddress")
    @ResponseBody
    protected Object addUserAddress(
            @ApiParam(name = "userId", value = "用户Id", required = true, type = "String")
            @RequestParam("userId")
                    String userId,
            @ApiParam(name = "recName", value = "收货人姓名", required = true, type = "String")
            @RequestParam("recName")
                    String recName,
            @ApiParam(name = "recSex", value = "收货人性别(0是男1是女)", required = true, type = "Integer")
            @RequestParam("recSex")
                    Integer recSex,
            @ApiParam(name = "recPhone", value = "收货人电话", required = true, type = "String")
            @RequestParam("recPhone")
                    String recPhone,
            @ApiParam(name = "addressName", value = "地址名称", required = true, type = "String")
            @RequestParam("addressName")
                    String addressName,
            @ApiParam(name = "houseNum", value = "门牌号描述", required = true, type = "String")
            @RequestParam("houseNum")
                    String houseNum
    ) {
        try {
            Date dateNow = new Date();

            Address newAddress = new Address();
            newAddress.setId(UUID.randomUUID().toString());
            newAddress.setReceiverName(recName);
            newAddress.setReceiverSex(recSex);
            newAddress.setReceiverPhone(recPhone);
            newAddress.setAddressName(addressName);
            newAddress.setHouseNumber(houseNum);
            newAddress.setCreateUserId(userId);
            newAddress.setModifyUserId(userId);
            newAddress.setCreateDate(dateNow);
            newAddress.setModifyDate(dateNow);
            /*添加关联表新字段*/
            MapUserAddress mapUserAddress = new MapUserAddress();
            mapUserAddress.setId(UUID.randomUUID().toString());
            mapUserAddress.setAddressId(newAddress.getId());
            mapUserAddress.setUserId(userId);
            mapUserAddress.setCreateDate(dateNow);
            mapUserAddress.setModifyDate(dateNow);
            mapUserAddress.setCreateUserId(userId);
            mapUserAddress.setModifyUserId(userId);

            addressService.insertSelective(newAddress);
            mapUserAddressService.insert(mapUserAddress);

            return new AjaxMessage().Set(MsgType.Success, "用户插入地址成功", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error, "用户插入地址失败", null);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("updateUserInfo")
    @ResponseBody
    protected Object updateUserInfo(
            @ApiParam(name = "userId", value = "用户微信Id", required = true, type = "String")
            @RequestParam("userId")
                    String userId,
            @ApiParam(name = "userName", value = "用户名", type = "String")
            @RequestParam("username")
                    String username,
            @ApiParam(name = "realName", value = "用户真名", type = "String")
            @RequestParam("realName")
                    String realName,
            @ApiParam(name = "nickName", value = "用户昵称", type = "String")
            @RequestParam("nickName")
                    String nickName,
            @ApiParam(name = "sex", value = "用户性别", type = "String")
            @RequestParam("sex")
                    Integer sex,
            @ApiParam(name = "telephone", value = "用户电话", type = "Integer")
            @RequestParam("telephone")
                    String telephone,
            @ApiParam(name = "email", value = "用户邮箱", type = "String")
            @RequestParam("email")
                    String email
    ) {
        try {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(username);
            sysUser.setSex(sex);
            sysUser.setTelephone(telephone);
            sysUser.setRealName(realName);
            sysUser.setNickName(nickName);
            sysUser.setEmail(email);
            sysUser.setId(userId);

            System.out.println(sysUser.getId());
            sysUserService.updateByPrimaryKeySelective(sysUser);
            return new AjaxMessage().Set(MsgType.Success, "更新用户信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "更新用户信息失败");
    }


    @ApiOperation(value = "删除用户地址")
    @PostMapping("deletUserAddress")
    @ResponseBody
    public Object deletUserAddress(
            @ApiParam(name = "userId", value = "用户微信Id", required = true, type = "String")
            @RequestParam("userId")
                    String userId,
            @ApiParam(name = "addressId", value = "地址Id", type = "String")
            @RequestParam("addressId")
                    String addressId
    ) {
        try {
            mapUserAddressService.deleteByUserIdAndId(userId, addressId);
            addressService.deleteByPrimaryKey(addressId);
            return new AjaxMessage().Set(MsgType.Success, "删除用户地址成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "删除用户地址失败");
    }
}
