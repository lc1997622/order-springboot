package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.*;
import com.ccorder.ordersystem.entity.mapEntity.MapFile;
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

    @ApiOperation(value = "获取客户端用户信息")
    @PostMapping("getUserInfo")
    @ResponseBody
    public Object getUserInfo(
            @ApiParam(name = "userId", value = "用户的微信ID", required = true,type = "String")
            @RequestParam
            String userId
    ){
        ClientUser clientUser= sysUserService.getClientUserInfo(userId);
        return new AjaxMessage().Set(MsgType.Success, "获取用户信息成功", clientUser);
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
//
//        List<File> files = clientUser.getUserimgs();

        return new AjaxMessage().Set(MsgType.Success,"插入新用户失败");
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
        return new AjaxMessage().Set(MsgType.Success,"获取用户地址失败");
    }

    @ApiOperation(value = "加入用户地址")
    @PostMapping("addUserAddress")
    @ResponseBody
    protected Object addUserAddress(
            @ApiParam(name = "address",value = "用户地址",required = true,type = "Address")
            Address address,
            @ApiParam(name = "userId",value = "用户微信Id",required = true,type = "String")
            String userId
    ){
        try {
            MapUserAddress mapUserAddress = new MapUserAddress();
            mapUserAddress.setAddressId(address.getId());
            mapUserAddress.setUserId(userId);
            Date tmpDate = new Date();
            mapUserAddress.setCreateDate(tmpDate);
            mapUserAddress.setModifyDate(tmpDate);
            mapUserAddress.setId(UUID.randomUUID().toString());
            address.setId(UUID.randomUUID().toString());
            mapUserAddressService.insert(mapUserAddress);
            addressService.insert(address);

            return new AjaxMessage().Set(MsgType.Success,"用户插入地址成功");
        }catch (Exception e){
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Success,"用户插入地址失败");
    }
}
