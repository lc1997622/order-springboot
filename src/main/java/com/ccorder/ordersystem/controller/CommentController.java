package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zm
 * @description 评论Controller
 * @data 2019/5/22
 */
@Controller
@RequestMapping(value = "/comment")
@Api(tags = "评论Api")
public class CommentController {


    @ApiOperation(value = "查看评论(根据orderId)")
    @PostMapping("viewOrderComment")
    @ResponseBody
    public Object viewOrderComment(
            @ApiParam(name = "orderId", value = "订单的主键id", required = true,type = "String")
            @RequestParam("orderId")
            String orderId
    ){
        try{

        }catch (Exception e){
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error,"返回评论内容失败",null);
    }

}
