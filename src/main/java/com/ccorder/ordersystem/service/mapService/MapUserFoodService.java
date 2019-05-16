package com.ccorder.ordersystem.service.mapService;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserFoodMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapUserFood;
@Service
public class MapUserFoodService{

    @Resource
    private MapUserFoodMapper mapUserFoodMapper;

    
    public int insert(MapUserFood record) {
        return mapUserFoodMapper.insert(record);
    }

    
    public int insertSelective(MapUserFood record) {
        return mapUserFoodMapper.insertSelective(record);
    }

}
