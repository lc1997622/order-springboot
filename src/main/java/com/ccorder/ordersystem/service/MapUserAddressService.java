package com.ccorder.ordersystem.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.mapMapper.MapUserAddressMapper;
import com.ccorder.ordersystem.entity.mapEntity.MapUserAddress;

import java.util.List;

@Service
public class MapUserAddressService{

    @Resource
    private MapUserAddressMapper mapUserAddressMapper;

    
    public int deleteByPrimaryKey(String id) {
        return mapUserAddressMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(MapUserAddress record) {
        return mapUserAddressMapper.insert(record);
    }

    
    public int insertSelective(MapUserAddress record) {
        return mapUserAddressMapper.insertSelective(record);
    }

    
    public MapUserAddress selectByPrimaryKey(String id) {
        return mapUserAddressMapper.selectByPrimaryKey(id);
    }

    public List<MapUserAddress> selectByUserId(String userId){return mapUserAddressMapper.selectByUserId(userId);}
    
    public int updateByPrimaryKeySelective(MapUserAddress record) {
        return mapUserAddressMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(MapUserAddress record) {
        return mapUserAddressMapper.updateByPrimaryKey(record);
    }

    public int deleteByUserIdAndId(String userId, String addressId){return mapUserAddressMapper.deleteByUserIdAndId(userId,addressId);}

}
