package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.SysDict;
import org.apache.ibatis.annotations.Param;

public interface SysDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    /**
     * 根据名字和状态查询返回sys_dict_type的id
     * 
     * @param nameEn
     * @param status
     * @return java.lang.String
     * @author zm
     * @date 10:58 2019/5/17
     */
    String selectByNameEnAndStatus(@Param("nameEn") String nameEn, @Param("status") int status);
}