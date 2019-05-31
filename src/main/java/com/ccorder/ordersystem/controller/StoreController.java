package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.entity.mapEntity.MapUserAddress;
import com.ccorder.ordersystem.service.AddressService;
import com.ccorder.ordersystem.service.MapUserAddressService;
import com.ccorder.ordersystem.service.SysUserService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zm
 * @description
 * @data 2019/5/29
 */
@Controller
@RequestMapping(value = "/store")
@Api(tags = "商家Api")
public class StoreController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MapUserAddressService mapUserAddressService;

    @ApiOperation(value = "获取商家信息")
    @PostMapping(value = "getStoreInfo")
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

    @ApiOperation(value = "修改商家信息(修改成功后返回更新后的商家)")
    @PostMapping("updateStoreInfo")
    @ResponseBody
    public Object updateStoreInfo(
            @ApiParam(name = "sysUser", value = "商家主键id", required = true, type = "SysUser")
            @RequestBody
                    SysUser sysUser
    ) {
        try {
            sysUserService.updateByPrimaryKeySelective(sysUser);
            return new AjaxMessage().Set(MsgType.Success, "更新商家信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "更新商家信息失败", null);
    }
}
