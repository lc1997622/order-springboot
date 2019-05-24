package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.ClientUser;
import com.ccorder.ordersystem.service.SysUserService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
