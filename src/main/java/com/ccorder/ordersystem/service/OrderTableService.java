package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.OrderTableMapper;
import com.ccorder.ordersystem.entity.OrderTable;

import java.util.List;

@Service
public class OrderTableService{

    @Resource
    private OrderTableMapper orderTableMapper;

    
    public int deleteByPrimaryKey(String id) {
        return orderTableMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(OrderTable record) {
        return orderTableMapper.insert(record);
    }

    
    public int insertSelective(OrderTable record) {
        return orderTableMapper.insertSelective(record);
    }

    
    public OrderTable selectByPrimaryKey(String id) {
        return orderTableMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(OrderTable record) {
        return orderTableMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(OrderTable record) {
        return orderTableMapper.updateByPrimaryKey(record);
    }

    public List<OrderTable> getUserOrders(String userId){
        return orderTableMapper.selectByUserId(userId);
    }
}
