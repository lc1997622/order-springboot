package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.CommentMapper;
import com.ccorder.ordersystem.entity.Comment;

@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;


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

}

