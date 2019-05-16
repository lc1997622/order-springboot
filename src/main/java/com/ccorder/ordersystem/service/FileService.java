package com.ccorder.ordersystem.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.ccorder.ordersystem.mapper.FileMapper;
import com.ccorder.ordersystem.entity.File;
@Service
public class FileService{

    @Resource
    private FileMapper fileMapper;

    
    public int deleteByPrimaryKey(String id) {
        return fileMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(File record) {
        return fileMapper.insert(record);
    }

    
    public int insertSelective(File record) {
        return fileMapper.insertSelective(record);
    }

    
    public File selectByPrimaryKey(String id) {
        return fileMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(File record) {
        return fileMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(File record) {
        return fileMapper.updateByPrimaryKey(record);
    }

}
