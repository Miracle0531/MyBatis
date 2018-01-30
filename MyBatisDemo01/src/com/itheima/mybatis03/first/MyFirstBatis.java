package com.itheima.mybatis03.first;

import com.itheima.mybatis03.po.User;
import org.junit.Test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>Titel:MyFirstBatis</p>
 * <p>Description:myBatis案例</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-29 11:21
 */
public class MyFirstBatis {

    /**
     * 根据用户ID查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {

        // myBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用sqlSession查询用户
        /**
         * sqlSession中的第一个参数:mapper.xml中statement的id,前边要加上namespace
         * sqlSession中的第二个参数:输入对象的参数值
         * selectOne用于返回一个数据信息
         */
        User user = sqlSession.selectOne("test.findUserById", 1);

        System.out.println(user);

        // 关闭sqlSession
        sqlSession.close();

    }

    /**
     * 根据用户名查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserByUsername() throws Exception {

        // myBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用sqlSession查询用户
        /**
         * sqlSession中的第一个参数:mapper.xml中statement的id,前边要加上namespace
         * sqlSession中的第二个参数:输入对象的参数值
         * selectOne用于返回一个数据信息
         */
        List<User> list = sqlSession.selectList("test.findUserByUsername", "张");

        for (User user : list) {
            System.out.println(user);
        }

        // 关闭sqlSession
        sqlSession.close();

    }

    /**
     * 查询所有用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindAllUser() throws Exception {

        // myBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用sqlSession查询用户
        /**
         * sqlSession中的第一个参数:mapper.xml中statement的id,前边要加上namespace
         * sqlSession中的第二个参数:输入对象的参数值
         * selectOne用于返回一个数据信息
         */
        List<User> list = sqlSession.selectList("test.findAllUser");

        for (User user : list) {
            System.out.println(user);
        }

        // 关闭sqlSession
        sqlSession.close();

    }

    /**
     * 添加用户信息
     *
     * @throws Exception
     */
    @Test
    public void testAddUser() throws Exception {

        // myBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 构造参数信息;使用sqlSession添加用户
        User user = new User();
        user.setUsername("马化腾");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳");

        // 插入数据
        sqlSession.insert("test.insertUser", user);

        // 提交事务
        sqlSession.commit();

        // 关闭sqlSession
        sqlSession.close();

    }

    /**
     * 修改用户信息
     *
     * @throws Exception
     */
    @Test
    public void testUpdateUser() throws Exception {

        // myBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 构造参数信息;使用sqlSession添加用户
        User user = new User();
        user.setId(10);
        user.setUsername("马化腾");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳");

        // 插入数据
        sqlSession.update("test.updateUserById", user);

        // 提交事务
        sqlSession.commit();

        // 关闭sqlSession
        sqlSession.close();

    }

    /**
     * 删除用户信息
     *
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception {

        // myBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 创建SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 删除数据
        sqlSession.delete("test.deleteUser", 10);

        // 提交事务
        sqlSession.commit();

        // 关闭sqlSession
        sqlSession.close();

    }

}
