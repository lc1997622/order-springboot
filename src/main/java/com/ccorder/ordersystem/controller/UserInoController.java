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

import javax.xml.crypto.Data;
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

    @ApiOperation(value = "获取客户端用户信息")
    @PostMapping("getUserInfo")
    @ResponseBody
    public Object getUserInfo(
            @ApiParam(name = "userId", value = "用户的微信ID", required = true,type = "String")
            @RequestParam
            String userId
    ){
        try {
            ClientUser clientUser= sysUserService.getClientUserInfo(userId);
            return new AjaxMessage().Set(MsgType.Success, "获取用户信息成功", clientUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "获取用户信息失败");
    }

    @ApiOperation(value = "插入新用户")
    @PostMapping("addNewUser")
    @ResponseBody
    protected Object addNewUser(
            @ApiParam(name = "clientUser",value = "用户信息",required = true,type = "ClientUser")
            ClientUser clientUser
    ){
        SysUser sysUser = new SysUser();
        sysUser.setId(clientUser.getId());
        sysUser.setBirthday(clientUser.getBirthday());
        sysUser.setEmail(clientUser.getEmail());
        sysUser.setNickName(clientUser.getNickName());
        sysUser.setPassword(clientUser.getPassword());
        sysUser.setRealName(clientUser.getRealName());
        sysUser.setSex(clientUser.getSex());
        sysUser.setTelephone(clientUser.getTelephone());
        sysUser.setUsername(clientUser.getUsername());
        Date tmpDate = new Date();
        sysUser.setCreateTime(tmpDate);
        sysUser.setModifyTime(tmpDate);

        List<SysRole> sysRoles = clientUser.getRoles();

        try {
            sysUserService.insert(sysUser);
            for (SysRole sysRole:sysRoles){
                MapUserRole mapUserRole = new MapUserRole();
                mapUserRole.setId(UUID.randomUUID().toString());
                mapUserRole.setUserId(sysUser.getId());
                mapUserRole.setRoleId(sysRole.getId());
                mapUserRole.setCreateUserId(sysUser.getId());
                mapUserRole.setCreateDate(tmpDate);
                mapUserRole.setModifyDate(tmpDate);
                mapUserRole.setModifyUserId(sysUser.getId());
                mapUserRoleService.insert(mapUserRole);
                sysRole.setId(UUID.randomUUID().toString());
                sysRoleService.insert(sysRole);
                return new AjaxMessage().Set(MsgType.Success,"插入新用户成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error,"插入新用户失败");
    }

    @ApiOperation(value = "获取用户地址")
    @PostMapping("getUserAddress")
    @ResponseBody
    protected Object getUserAddress(
            @ApiParam(name = "userId",value = "用户微信ID",required = true,type = "String")
                    String userId
    ){
        List<Address> addresses = new ArrayList<>();
        try{
            List<MapUserAddress> mapUserAddresses = mapUserAddressService.selectByUserId(userId);
            for (MapUserAddress userAddress:mapUserAddresses){
                Address address = addressService.selectByPrimaryKey(userAddress.getAddressId());
                addresses.add(address);
            }
            return new AjaxMessage().Set(MsgType.Success,"获取用户地址成功",addresses);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error,"获取用户地址失败");
    }

    @ApiOperation(value = "加入用户地址")
    @PostMapping("addUserAddress")
    @ResponseBody
    protected Object addUserAddress(
            @ApiParam(name = "addressName",value = "用户地址",required = true,type = "String")
            String addressName,
            @ApiParam(name = "houseNumber",value = "地址编号",required = true,type = "String")
            String houseNumber,
            @ApiParam(name = "userId",value = "用户微信Id",required = true,type = "String")
            String userId,
            @ApiParam(name = "receiverName",value = "收货人姓名",required = true,type = "String")
            String receiverName,
            @ApiParam(name = "receiverPhone",value = "收货人电话",required = true,type = "String")
            String receiverPhone,
            @ApiParam(name = "sex",value = "收货人性别",required = true,type = "String")
            String sex
    ){
        try {
            String addressId = UUID.randomUUID().toString();
            MapUserAddress mapUserAddress = new MapUserAddress();
            Address address = new Address();
            mapUserAddress.setAddressId(addressId);
            mapUserAddress.setUserId(userId);
            Date tmpDate = new Date();
            mapUserAddress.setCreateDate(tmpDate);
            mapUserAddress.setModifyDate(tmpDate);
            mapUserAddress.setId(UUID.randomUUID().toString());
            address.setId(addressId);
            address.setAddressName(addressName);
            address.setHouseNumber(houseNumber);
            address.setReceiverName(receiverName);
            address.setReceiverPhone(receiverPhone);
            address.setReceiverSex(sex);
            address.setCreateUserId(userId);
            address.setModifyUserId(userId);
            address.setCreateDate(tmpDate);
            address.setModifyDate(tmpDate);
            address.setStatus(1);
            mapUserAddressService.insert(mapUserAddress);
            addressService.insert(address);

            return new AjaxMessage().Set(MsgType.Success,"用户插入地址成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error,"用户插入地址失败");
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("updateUserInfo")
    @ResponseBody
    protected Object updateUserInfo(
            @ApiParam(name = "userId",value = "用户微信Id",required = true,type = "String")
            String userId,
            @ApiParam(name = "userName",value = "用户名",type = "String")
            String userName,
            @ApiParam(name = "realName",value = "用户真名",type = "String")
            String realName,
            @ApiParam(name = "nickName",value = "用户昵称",type = "String")
            String nickName,
            @ApiParam(name = "sex",value = "用户性别",type = "String")
            Integer sex,
            @ApiParam(name = "telephone",value = "用户电话",type = "Integer")
            String telephone,
            @ApiParam(name = "email",value = "用户邮箱",type = "String")
            String email
    ){
        try {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(userName);
            sysUser.setSex(sex);
            sysUser.setTelephone(telephone);
            sysUser.setRealName(realName);
            sysUser.setNickName(nickName);
            sysUser.setEmail(email);
            sysUser.setId(userId);

            System.out.println(sysUser.getId());
            sysUserService.updateByPrimaryKeySelective(sysUser);
            return new AjaxMessage().Set(MsgType.Success,"更新用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error,"更新用户信息失败");
    }
}
