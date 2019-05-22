package com.ccorder.ordersystem.mapper;

import org.apache.ibatis.annotations.Param;

import com.ccorder.ordersystem.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    Comment selectByOrderId(@Param("orderId") String orderId);
}