package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.entity.SysRole;
import com.ccorder.ordersystem.mapper.SysRoleMapper;

@Service
public class SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;


    public int deleteByPrimaryKey(String id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }


    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }


    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }


    public SysRole selectByPrimaryKey(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

}

