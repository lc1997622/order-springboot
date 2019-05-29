package com.ccorder.ordersystem.controller;

import com.ccorder.ordersystem.entity.Comment;
import com.ccorder.ordersystem.service.CommentService;
import com.ccorder.ordersystem.sys.dto.AjaxMessage;
import com.ccorder.ordersystem.sys.dto.MsgType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author zm
 * @description 评论Controller
 * @data 2019/5/22
 */
@Controller
@RequestMapping(value = "/comment")
@Api(tags = "评论Api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "查看评论(根据orderId)")
    @PostMapping("viewOrderComment")
    @ResponseBody
    public Object viewOrderComment(
            @ApiParam(name = "orderId", value = "订单的主键id", required = true, type = "String")
            @RequestParam("orderId")
                    String orderId
    ) {
        try {
            Comment tarComment = commentService.getOrderComment(orderId);
            return new AjaxMessage().Set(MsgType.Success, "返回评论内容成功", tarComment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error, "返回评论内容失败", null);
    }

    @ApiOperation(value = "插入评论(根据orderId)")
    @PostMapping("addNewComment")
    @ResponseBody
    public Object addNewComment(
            @ApiParam(name = "newComment", value = "待插入的评论", required = true, type = "Comment")
            @RequestBody
                    Comment newComment
    ) {
        try {
            newComment.setId(UUID.randomUUID().toString());
            commentService.insertSelective(newComment);
            return new AjaxMessage().Set(MsgType.Success, "新增评论成功", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new AjaxMessage().Set(MsgType.Error, "新增评论失败", null);
    }

    @ApiOperation(value = "查看商家的评论列表(根据商家userId)")
    @PostMapping("viewStoreComment")
    @ResponseBody
    public Object viewStoreComment(
            @ApiParam(name = "userId", value = "商家用户的userId", required = true, type = "String")
            @RequestParam("userId")
                    String userId
    ) {
        try {
            List<Comment> commentList = commentService.getStoreComment(userId);
            return new AjaxMessage().Set(MsgType.Success, "获取商家评论成功", commentList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new AjaxMessage().Set(MsgType.Error, "获取商家评论失败", null);
    }
}
