package com.ccorder.ordersystem.mapper.mapMapper;

import com.ccorder.ordersystem.entity.mapEntity.MapUserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapUserAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(MapUserAddress record);

    int insertSelective(MapUserAddress record);

    MapUserAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MapUserAddress record);

    int updateByPrimaryKey(MapUserAddress record);

    List<MapUserAddress> selectByUserId(String userId);

    String selectByUserIdGetAddressId(String BusinessId);

    int deleteByUserIdAndId(@Param("userId")String userId, @Param("addressId") String addressId);
}