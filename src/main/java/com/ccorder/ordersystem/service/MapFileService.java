package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.entity.mapEntity.MapFile;
import com.ccorder.ordersystem.mapper.mapMapper.MapFileMapper;

@Service
public class MapFileService {

    @Resource
    private MapFileMapper mapFileMapper;


    public int insert(MapFile record) {
        return mapFileMapper.insert(record);
    }


    public int insertSelective(MapFile record) {
        return mapFileMapper.insertSelective(record);
    }

}

