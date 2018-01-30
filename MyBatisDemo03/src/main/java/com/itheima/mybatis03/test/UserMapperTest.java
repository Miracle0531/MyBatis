package com.itheima.mybatis03.test;

import com.itheima.mybatis03.mapper.UserMapper;
import com.itheima.mybatis03.pojo.QueryUserVo;
import com.itheima.mybatis03.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Titel:UserMapperTest</p>
 * <p>Description:用户Mapper的测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 16:15
 */
@SuppressWarnings("all")
public class UserMapperTest {

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
     * 查询指定用户
     *
     * @throws Exception
     */
    @Test
    public void testFindUserByName() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("张");
        user.setSex("1");
        queryUserVo.setUser(user);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(10);
        queryUserVo.setIds(ids);

        List<User> list = userMapper.findUserByName(queryUserVo);
        System.out.println(list);
        sqlSession.close();

    }

}