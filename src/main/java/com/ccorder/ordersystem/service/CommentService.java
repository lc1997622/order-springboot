package com.ccorder.ordersystem.service;

import com.ccorder.ordersystem.entity.OrderTable;
import com.ccorder.ordersystem.entity.SysUser;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.CommentMapper;
import com.ccorder.ordersystem.entity.Comment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Autowired
    private OrderTableMapper orderTableMapper;

    @Autowired
    private MapUserOrderMapper mapUserOrderMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    public int deleteByPrimaryKey(String id) {
        return commentMapper.deleteByPrimaryKey(id);
    }


    public int insert(Comment record) {
        return commentMapper.insert(record);
    }


    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }


    public Comment selectByPrimaryKey(String id) {
        return commentMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    /** 根据orderId获取评论*/
    public Comment getOrderComment(String orderId) {
        return commentMapper.selectByOrderId(orderId);
    }

    /** 根据userId获取店家全部评论*/
    public List<Comment> getStoreComment(String userId) {
        System.out.println("1----------------------");
        /*获取全部订单*/
        List<OrderTable> orderTableList = orderTableMapper.selectByUserId(userId);
        List<Comment> commentList=new ArrayList<Comment>();
        /*根据订单号获取全部评论，并添加订单评分*/
        for (int i = 0; i < orderTableList.size(); i++) {
            Comment tmpComment = new Comment();
            String tmpOrderId = orderTableList.get(i).getId();
            tmpComment = commentMapper.selectByOrderId(tmpOrderId);
            if(tmpComment!=null) {
                tmpComment.setScore(orderTableList.get(i).getScore());
                commentList.add(tmpComment);
            }
        }
        return commentList;
    }

    /** 根据userId获取店家全部评论*/
    public List<SysUser> getStoreCommentName(String userId) {
        System.out.println("1----------------------");
        /*获取全部订单*/
        List<OrderTable> orderTableList = orderTableMapper.selectByUserId(userId);
        List<SysUser> nameList=new ArrayList<SysUser>();
        /*根据订单号获取全部评论，并添加订单评分*/
        for (int i = 0; i < orderTableList.size(); i++) {
            Comment tmpComment = new Comment();
            String tmpOrderId = orderTableList.get(i).getId();
            tmpComment = commentMapper.selectByOrderId(tmpOrderId);
            if(tmpComment!=null){
                String sysUserId=tmpComment.getCreateUserId();
                SysUser sysUser=sysUserMapper.selectByPrimaryKey(sysUserId);
                nameList.add(sysUser);
            }
        }
        return nameList;
    }
}

