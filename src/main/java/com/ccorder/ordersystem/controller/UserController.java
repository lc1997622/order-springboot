package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.service.AddressService;
import com.ccorder.ordersystem.service.MapUserAddressService;
import com.ccorder.ordersystem.service.SysUserService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author htj
 * @description
 * @data 2019/5/17
 */
@Controller
@RequestMapping(value = "/user")
@Api(tags = "用户API")
public class UserController {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private MapUserAddressService mapUserAddressService;

    @ApiOperation(value = "获取商家信息")
    @PostMapping(value = "getBusiness")
    @ResponseBody
    public Object getBusiness(
            @ApiParam(name = "userId", value = "商家的用户id", required = true, type = "String")
            @RequestParam(value = "userId")
                    String userId
    ) {
        try {
            //返回商家业务信息
            SysUser store = sysUserService.selectByPrimaryKey(userId);
            //获取商家地址
            String storeAddressId = mapUserAddressService.selectByUserId(userId).get(0).getAddressId();
            store.setStoreAddress(addressService.selectByPrimaryKey(storeAddressId));
            return new AjaxMessage().Set(MsgType.Success, "成功返回商家信息", store);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success, "获取商家信息失败",null);
    }
}
