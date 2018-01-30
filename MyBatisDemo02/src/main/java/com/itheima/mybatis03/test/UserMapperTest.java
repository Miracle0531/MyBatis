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

import javax.management.Query;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>Titel:UserMapperTest</p>
 * <p>Description:输入映射的测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 11:36
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
    public void testFindUserList() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("张");
        user.setSex("1");
        queryUserVo.setUser(user);

        List<User> list = userMapper.findUserList(queryUserVo);
        System.out.println(list);

        sqlSession.close();
    }

    @Test
    public void testFindAllUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.findAllUser();

        System.out.println(list);

        sqlSession.close();

    }

    /**
     * 删除指定用户
     *
     * @throws Exception
     */
    @Test
    public void testDelteUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUserById("26");

        // 提交事务
        sqlSession.commit();

        testFindAllUser();

        sqlSession.close();

    }

    /**
     * 添加用户
     *
     * @throws Exception
     */
    @Test
    public void testInsertUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("马化腾");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳");

        queryUserVo.setUser(user);
        userMapper.insertUser(queryUserVo);

        // 提交事务
        sqlSession.commit();

        testFindAllUser();

        sqlSession.close();

    }

    /**
     * 修改指定用户
     *
     * @throws Exception
     */
    @Test
    public void testUpdateUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 创建代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        QueryUserVo queryUserVo = new QueryUserVo();
        User user = new User();
        user.setUsername("马云");
        user.setBirthday(new Date());
        user.setSex("女");
        user.setAddress("杭州");
        queryUserVo.setUser(user);

        userMapper.updateUser(queryUserVo);

        // 提交事务
        sqlSession.commit();

        testFindAllUser();

        sqlSession.close();

    }

}
