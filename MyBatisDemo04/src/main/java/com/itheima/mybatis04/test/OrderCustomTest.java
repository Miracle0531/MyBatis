package com.itheima.mybatis04.test;

import com.itheima.mybatis04.mapper.OrderCustomMapper;
import com.itheima.mybatis04.pojo.OrderCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * <p>Titel:OrderCustomTest</p>
 * <p>Description:用户订单信息的测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 20:38
 */
@SuppressWarnings("all")
public class OrderCustomTest {

    private SqlSessionFactory sqlSessionFactory;

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

    /**
     * 查询指定信息的用户订单
     *
     * @throws Exception
     */
    @Test
    public void testFindOrderAndUserByResultType() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        OrderCustomMapper orderCustomMapper = sqlSession.getMapper(OrderCustomMapper.class);
        List<OrderCustom> list = orderCustomMapper.findOrderAndUserByResultType();
        System.out.println(list);

    }

}
