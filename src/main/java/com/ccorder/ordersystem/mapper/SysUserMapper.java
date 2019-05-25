package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.ClientUser;
import com.ccorder.ordersystem.entity.SysRole;
import com.ccorder.ordersystem.entity.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    //int insertBusiness(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    int insertBusiness(SysUser record);

    ClientUser getClientUserInfo(String userId);

    SysUser selectByCreateUserIdGetUser(String createUserId);

    SysUser selectByBusinessIdGetUser(String businessId);
}