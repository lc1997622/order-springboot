package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Address;
import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.service.AddressService;
import com.ccorder.ordersystem.service.MapUserAddressService;
import com.ccorder.ordersystem.service.OrderTableService;
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
import java.util.List;

/**
 * @author zm
 * @description
 * @data 2019/5/31
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

    @Autowired
    private OrderTableService orderTableService;

    @ApiOperation(value = "获取用户全部订单")
    @PostMapping(value = "getUserOrders")
    @ResponseBody
    public Object getBusiness(
            @ApiParam(name = "userId", value = "用户端id", required = true, type = "String")
            @RequestParam(value = "userId")
                    String userId
    ){
        try{
            List<OrderTable> orders = orderTableService.getUserOrders(userId);
            return new AjaxMessage().Set(MsgType.Success,"获取用户全部订单成功",orders);
        }catch (Exception e){
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error,"获取用户全部订单错误",null);
    }
}
