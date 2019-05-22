package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.AddressMapper;
import com.ccorder.ordersystem.entity.Address;
@Service
public class AddressService{

    @Resource
    private AddressMapper addressMapper;

    
    public int deleteByPrimaryKey(String id) {
        return addressMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    
    public Address selectByPrimaryKey(String id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

}
