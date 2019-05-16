package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.entity.MapUserRole;
import com.ccorder.ordersystem.mapper.MapUserRoleMapper;
@Service
public class MapUserRoleService{

    @Resource
    private MapUserRoleMapper mapUserRoleMapper;

    
    public int deleteByPrimaryKey(String id) {
        return mapUserRoleMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MapUserRole record) {
        return mapUserRoleMapper.insert(record);
    }

    
    public int insertSelective(MapUserRole record) {
        return mapUserRoleMapper.insertSelective(record);
    }

    
    public MapUserRole selectByPrimaryKey(String id) {
        return mapUserRoleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(MapUserRole record) {
        return mapUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MapUserRole record) {
        return mapUserRoleMapper.updateByPrimaryKey(record);
    }

}
