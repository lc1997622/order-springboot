package com.ccorder.ordersystem.service;

import com.ccorder.ordersystem.entity.ClientUser;
import com.ccorder.ordersystem.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.SysUserMapper;
import com.ccorder.ordersystem.entity.SysUser;

@Service
public class SysUserService {

    @Autowired
    SysUserMapper sysUserMapper1;

    @Resource
    private SysUserMapper sysUserMapper;


    public int deleteByPrimaryKey(String id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }


    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }


    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }


    public SysUser selectByPrimaryKey(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    public ClientUser getClientUserInfo(String userId){
        return sysUserMapper1.getClientUserInfo(userId);
    }
}

