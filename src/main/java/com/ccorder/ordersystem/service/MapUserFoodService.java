package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
@Service
public class MapUserFoodService{

    @Resource
    private MapUserFoodMapper mapUserFoodMapper;

    
    public int deleteByPrimaryKey(String id) {
        return mapUserFoodMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MapUserFood record) {
        return mapUserFoodMapper.insert(record);
    }

    
    public int insertSelective(MapUserFood record) {
        return mapUserFoodMapper.insertSelective(record);
    }

    
    public MapUserFood selectByPrimaryKey(String id) {
        return mapUserFoodMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(MapUserFood record) {
        return mapUserFoodMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MapUserFood record) {
        return mapUserFoodMapper.updateByPrimaryKey(record);
    }

}
