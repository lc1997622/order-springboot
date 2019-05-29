package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.SysUser;
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

    @ApiOperation(value = "修改商家信息(修改成功后返回更新后的商家)")
    @PostMapping("updateStoreInfo")
    @ResponseBody
    public Object updateStoreInfo(
            @ApiParam(name = "storeId", value = "商家主键id", required = true, type = "String")
            @RequestParam("storeId")
                    String storeId,
            @ApiParam(name = "storeName", value = "商家店名", required = true, type = "String")
            @RequestParam("storeName")
                    String storeName,
            @ApiParam(name = "storeAddress", value = "商家地址", required = true, type = "String")
            @RequestParam("storeAddress")
                    String storeAddress,
            @ApiParam(name = "shipFee", value = "配送费", required = true, type = "Double")
            @RequestParam("shipFee")
                    Double shipFee,
            @ApiParam(name = "shopStatus", value = "营业状态", required = true, type = "Integer")
            @RequestParam("shopStatus")
                    Integer shopStatus,
            @ApiParam(name = "storeIntroduce", value = "商家介绍信息", required = true, type = "String")
            @RequestParam("storeIntroduce")
                    String storeIntroduce
    ) {
        try {
            /*获取原有店铺user*/
            SysUser storeNow = userService.selectByPrimaryKey(storeId);
            /*更新用户信息*/
            storeNow.setRealName(storeName);
            Address newAddress = new Address();
            newAddress.setAddressName(storeAddress);
            storeNow.setStoreAddress(newAddress);
            storeNow.setShipFee(shipFee);
            storeNow.setStatus(shopStatus);
            storeNow.setBusinessIntroduction(storeIntroduce);

            int updateRes = userService.updateByPrimaryKeySelective(storeNow);
            if (updateRes == 1) {
                return new AjaxMessage().Set(MsgType.Success, "更新商家信息成功", storeNow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error, "更新商家信息失败", null);
    }
}
