package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.entity.mapEntity.MapUserAddress;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserAddressMapper;
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
import java.util.Date;
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

    @Autowired
    private MapUserAddressMapper mapUserAddressMapper;

    @Autowired
    private SysUserMapper sysUserMapper;
    @ApiOperation(value = "获取商家信息")
    @PostMapping(value = "getStoreInfo")
    @ResponseBody
    public Object getBusiness() {
        try {
            String storeId="store0001";
            //返回商家业务信息
            SysUser store = sysUserMapper.selectByBusinessIdGetUser(storeId);
            System.out.println(store);
            //获取商家地址
            String storeAddressId = mapUserAddressMapper.selectByUserIdGetAddressId(storeId);
            store.setStoreAddress(addressService.selectByPrimaryKey(storeAddressId));
            return new AjaxMessage().Set(MsgType.Success, "成功返回商家信息", store);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success, "获取商家信息失败",null);
    }

    @ApiOperation(value = "修改商家信息")
    @PostMapping("updateStoreInfo")
    @ResponseBody
    public Object updateStoreInfo(
            @ApiParam(name = "addressName", value = "商家需要修改的addressName", required = false, type = "String")
            @RequestParam(value = "addressName")
            String addressName,
            @ApiParam(name = "houseNum", value = "商家需要修改的houseNum" ,required = false, type = "String")
            @RequestParam(value = "houseNum")
                    String houseNum,
            @ApiParam(name = "businessIntroduction", value = "商家需要修改的自我介绍" ,required = false, type = "String")
            @RequestParam(value = "businessIntroduction")
                    String businessIntroduction,
            @ApiParam(name = "shipFee", value = "商家的配送费", required = false, type = "Double")
            @RequestParam(value = "shipFee")
                    Double shipFee
            ) {
        try {
            //获取原来商家的信息
            SysUser storeUser=sysUserService.selectByPrimaryKey("store0001");
            Date nowDate=new Date();
            //修改商家信息
            storeUser.setModifyTime(nowDate);
            storeUser.setModifyUserId("store0001");
            storeUser.setShipFee(shipFee);
            storeUser.setBusinessIntroduction(businessIntroduction);
            sysUserService.updateByPrimaryKeySelective(storeUser);

            //获取商家的地址信息
            String addressId=mapUserAddressMapper.selectByUserIdGetAddressId("store0001");
            System.out.println(addressId);
            Address address=addressService.selectByPrimaryKey(addressId);
            System.out.println(address);
            //修改商家地址信息
            address.setModifyDate(nowDate);
            address.setModifyUserId("store0001");
            address.setHouseNumber(houseNum);
            address.setAddressName(addressName);
            addressService.updateByPrimaryKeySelective(address);
            return new AjaxMessage().Set(MsgType.Success, "更新商家信息成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "更新商家信息失败", null);
    }
}
