package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.entity.MapOrderFood;
import com.ccorder.ordersystem.mapper.MapOrderFoodMapper;
@Service
public class MapOrderFoodService{

    @Resource
    private MapOrderFoodMapper mapOrderFoodMapper;

    
    public int deleteByPrimaryKey(String id) {
        return mapOrderFoodMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MapOrderFood record) {
        return mapOrderFoodMapper.insert(record);
    }

    
    public int insertSelective(MapOrderFood record) {
        return mapOrderFoodMapper.insertSelective(record);
    }

    
    public MapOrderFood selectByPrimaryKey(String id) {
        return mapOrderFoodMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(MapOrderFood record) {
        return mapOrderFoodMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MapOrderFood record) {
        return mapOrderFoodMapper.updateByPrimaryKey(record);
    }

}
