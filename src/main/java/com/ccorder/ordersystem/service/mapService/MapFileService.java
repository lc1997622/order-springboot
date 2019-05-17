package com.ccorder.ordersystem.service.mapService;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.mapMapper.MapFileMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapFile;
@Service
public class MapFileService{

    @Resource
    private MapFileMapper mapFileMapper;

    
    public int insert(MapFile record) {
        return mapFileMapper.insert(record);
    }

    
    public int insertSelective(MapFile record) {
        return mapFileMapper.insertSelective(record);
    }

}
