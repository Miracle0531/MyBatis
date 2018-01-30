package com.itheima.mybatis05.test;

import com.itheima.mybatis05.mapper.OrderCustomMapper;
import com.itheima.mybatis05.pojo.Orders;
import com.itheima.mybatis05.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * <p>Titel:ResultMapTest</p>
 * <p>Description:ResultMap测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 18:45
 */
@SuppressWarnings("all")
public class ResultMapTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {

        // 创建SqlSessionFactory对象
        // 引入mybatis的全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据MyBatis全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * 使用resultMap进行一对一查询用户订单信息
     *
     * @throws Exception
     */
    @Test
    public void testFindOrderaAndUserByResultMap() throws Exception {

        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        OrderCustomMapper orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
        List<Orders> list = orderCustomMapper.findOrdersAndUserByResultMap();

        System.out.println(list);

        sqlSession.close();

    }

    /**
     * 使用resultMap进行多对多查询
     *
     * @throws Exception
     */
    @Test
    public void testFindOrdersAndOrderdetail() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        OrderCustomMapper orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
        List<Orders> list = orderCustomMapper.findOrdersAndOrderdetail();
        System.out.println(list);

        sqlSession.close();

    }

    /**
     * 多对多查询用户及订单商品信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserAndItems() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 创建代理对象
        OrderCustomMapper orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
        List<Orders> list = orderCustomMapper.findUserAndItems();
        System.out.println(list);

        sqlSession.close();

    }

    /**
     * 懒加载查询订单中的用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindOrdersLazyLoadingUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        OrderCustomMapper orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
        // 查询订单列表
        List<Orders> ordersList = orderCustomMapper.findOrdersLazyLoadingUser();
        // 取出第一个订单
        Orders orders = ordersList.get(0);
        // 获取订单中的用户信息
        User user = orders.getUser();

        System.out.println(user);

    }
}
