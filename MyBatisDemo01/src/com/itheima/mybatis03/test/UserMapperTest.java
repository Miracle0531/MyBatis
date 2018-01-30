package com.itheima.mybatis03.test;

import com.itheima.mybatis03.mapper.UserMapper;
import com.itheima.mybatis03.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>Titel:UserMapperTest</p>
 * <p>Description:用户操作的Mapper代理测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-05 20:25
 */
@SuppressWarnings("all")
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        // 创建sqlSessionFactory
        // MyBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据MyBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 根据ID查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 调用Mapper对象
        User user = userMapper.findUserById(1);

        System.out.println(user);

        sqlSession.close();

    }

    /**
     * 查询所有用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindAllUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 调用Mapper对象
        List<User> list = userMapper.findAllUser();

        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    /**
     * 根据用户名模糊查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserByName() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = userMapper.findUserByUsername("张");

        for (User user : list) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    /**
     * 添加用户信息
     *
     * @throws Exception
     */
    @Test
    public void testInsertUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 构造参数信息;使用sqlSession添加用户
        User user = new User();
        user.setUsername("马化腾");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳");

        userMapper.insertUser(user);

        // 必须对sqlSession进行commit操作,否则数据库会回滚数据
        sqlSession.commit();

        testFindAllUser();

        sqlSession.close();

    }

    /**
     * 删除指定ID用户信息
     *
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.deleteUser(30);

        // 必须对sqlSession进行commit操作,否则数据库会回滚数据
        sqlSession.commit();

        testFindAllUser();

        sqlSession.close();

    }

    /**
     * 修改指定ID用户信息
     *
     * @throws Exception
     */
    @Test
    public void testUpdateUser() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 构造参数信息;使用sqlSession添加用户
        User user = new User();
        user.setId(31);
        user.setUsername("马云");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("杭州");

        userMapper.updateUser(user);

        sqlSession.commit();

        testFindAllUser();

        sqlSession.close();

    }

}
