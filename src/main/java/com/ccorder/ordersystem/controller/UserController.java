package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private SysUserMapper sysUserMapper;

    @Autowired
    private AddressMapper addressMapper;

    @ApiOperation(value = "用户获取上商家信息")
    @GetMapping(value="/getBusiness")
    @ResponseBody
    public Object getBusiness(
            @ApiParam(name = "businessId", value = "商家id", required = true,type = "String")
            @RequestParam
                    String businessId
    ){
        class BusinessInfo{
            SysUser sysUser=null;
            String address=null;
        }
        try{
            BusinessInfo businessInfo=new BusinessInfo();
            //返回商家的营业时间（配送时间），评星，电话，自我介绍
            businessInfo.sysUser= sysUserMapper.selectByBusinessIdGetUser(businessId);
            //返回商家的地址
            businessInfo.address=addressMapper.selectByPrimaryKey(businessId).getAddressName();
            return new AjaxMessage().Set(MsgType.Success,"成功返回商家信息",businessInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"获取商家信息失败");
    }
}
