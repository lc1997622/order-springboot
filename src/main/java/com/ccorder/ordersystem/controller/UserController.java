package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
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
    private SysUserMapper sysUserMapper;

    @Autowired
    private AddressMapper addressMapper;

    @ApiOperation(value = "用户获取上商家信息")
    @PostMapping(value="/getBusiness")
    @ResponseBody
    public Object getBusiness(
            @ApiParam(name = "businessId", value = "商家id", required = true,type = "String")
            @RequestParam
                    String businessId
    ){
        @Data
        class BusinessInfo{
            Date startTime=null;
            Date endTime=null;
            String businessIntroduction=null;
            Integer starsNum=null;
            String address=null;
            String phoneNum=null;
        }
        try{
            BusinessInfo businessInfo=new BusinessInfo();
            //返回商家的营业时间（配送时间），评星，电话，自我介绍
            SysUser sysUser= sysUserMapper.selectByBusinessIdGetUser(businessId);
            businessInfo.starsNum=sysUser.getStarsNum();
            businessInfo.startTime=sysUser.getStartTime();
            businessInfo.endTime=sysUser.getEndTime();
            businessInfo.businessIntroduction=sysUser.getBusinessIntroduction();
            businessInfo.phoneNum=sysUser.getTelephone();
            //返回商家的地址
            businessInfo.address=addressMapper.selectByCreateUserIdGetAddressName(businessId);
            return new AjaxMessage().Set(MsgType.Success,"成功返回商家信息",businessInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Success,"获取商家信息失败");
    }
}
