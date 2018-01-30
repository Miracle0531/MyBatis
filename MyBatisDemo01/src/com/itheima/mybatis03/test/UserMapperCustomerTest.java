package com.itheima.mybatis03.test;

import com.itheima.mybatis03.mapper.UserMapperCustomer;
import com.itheima.mybatis03.po.QueryUserVo;
import com.itheima.mybatis03.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * <p>Titel:UserMapperCustomerTest</p>
 * <p>Description:自定义用户的测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 10:35
 */
@SuppressWarnings("all")
public class UserMapperCustomerTest {

    private SqlSessionFactory sqlSessionFactory;

    // @Before注解标识 的方法在测试方法执行之前去执行
    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据mybatis的全局配置文件构造 一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapperCustomer userMapperCustomer = sqlSession.getMapper(UserMapperCustomer.class);
        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("张");
        user.setSex("1");
        queryUserVo.setUser(user);

        List<User> users = userMapperCustomer.findUserList(queryUserVo);
        System.out.println(users);

        sqlSession.close();

    }

}
