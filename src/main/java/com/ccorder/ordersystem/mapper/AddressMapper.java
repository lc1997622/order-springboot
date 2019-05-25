package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    String selectByCreateUserIdGetAddressName(String businessId);

}