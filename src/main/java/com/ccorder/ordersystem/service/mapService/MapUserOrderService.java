package com.ccorder.ordersystem.service.mapService;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserOrderMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapUserOrder;
@Service
public class MapUserOrderService{

    @Resource
    private MapUserOrderMapper mapUserOrderMapper;

    
    public int deleteByPrimaryKey(String id) {
        return mapUserOrderMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MapUserOrder record) {
        return mapUserOrderMapper.insert(record);
    }

    
    public int insertSelective(MapUserOrder record) {
        return mapUserOrderMapper.insertSelective(record);
    }

    
    public MapUserOrder selectByPrimaryKey(String id) {
        return mapUserOrderMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(MapUserOrder record) {
        return mapUserOrderMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MapUserOrder record) {
        return mapUserOrderMapper.updateByPrimaryKey(record);
    }

}
