package com.ccorder.ordersystem.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Date;

/**
 * @author zm
 * @description
 * @data 2019/5/22
 */
public class FileMapperTest {
    private static FileMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(FileMapperTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/FileMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(FileMapper.class, builder.openSession(true));
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws FileNotFoundException {
        /*mapper.updateByPrimaryKeySelective();*/
        System.out.println(new Date());
    }
}
