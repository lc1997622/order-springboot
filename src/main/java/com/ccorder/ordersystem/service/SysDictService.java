package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.SysDictMapper;
import com.ccorder.ordersystem.entity.SysDict;

@Service
public class SysDictService {

    @Resource
    private SysDictMapper sysDictMapper;


    public int deleteByPrimaryKey(String id) {
        return sysDictMapper.deleteByPrimaryKey(id);
    }


    public int insert(SysDict record) {
        return sysDictMapper.insert(record);
    }


    public int insertSelective(SysDict record) {
        return sysDictMapper.insertSelective(record);
    }


    public SysDict selectByPrimaryKey(String id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(SysDict record) {
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SysDict record) {
        return sysDictMapper.updateByPrimaryKey(record);
    }

}

