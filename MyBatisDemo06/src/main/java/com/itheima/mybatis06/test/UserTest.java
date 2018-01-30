package com.itheima.mybatis06.test;


import com.itheima.mybatis06.mapper.UserMapper;
import com.itheima.mybatis06.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * <p>Titel:UserTest</p>
 * <p>Description:用户操作的测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-21 21:41
 */
@SuppressWarnings("all")
public class UserTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {

        // 创建SqlSessionFactory对象
        String resource = "SqlMapConfig.xml";

        // 根据Mybatis全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testFindUserById() throws Exception {

        // 创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(1);

        System.out.println(user);

        sqlSession.close();

    }

}
