package com.ccorder.ordersystem.mapper;

import com.ccorder.ordersystem.entity.Food;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

public class FoodMapperTest {
    private static FoodMapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().
                build(FoodMapperTest.class.getClassLoader()
                .getResourceAsStream("mybatisTestConfiguration/FoodMapperTestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(FoodMapper.class, builder.openSession(true));
    }

    @Test
    public void testSelectByPrimaryKey() throws FileNotFoundException {
        Food myFood =  mapper.selectByPrimaryKey("0438f4e5-2a1b-4547-829b-278f72b2d761");
        System.out.println(myFood);
    }
}
