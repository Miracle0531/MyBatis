package com.itheima.mybatis03.test;

import com.itheima.mybatis03.dao.UserDao;
import com.itheima.mybatis03.dao.UserDaoImpl;
import com.itheima.mybatis03.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * <p>Titel:UserDaoImplTest</p>
 * <p>Description:用户信息操作的测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-05 16:49
 */
@SuppressWarnings("all")
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    /**
     * @throws Exception
     * @Before 注解标识的方法在测试方法执行前去执行
     */
    @Before
    public void setUp() throws Exception {

        // 创建SqlSessionFactory
        // MyBatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据myBatis的全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * 根据用户ID查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用UserDao中的方法
        User user = userDao.findUserById(1);

        System.out.println(user);

    }

    /**
     * 根据用户名进行模糊查询
     *
     * @throws Exception
     */
    @Test
    public void testFindUserByName() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用UserDao中的方法
        List<User> list = userDao.findUserByName("张");

        for (User user : list) {
            System.out.println(user);
        }

    }

    /**
     * 删除用户信息
     *
     * @throws Exception
     */
    @Test
    public void testDeleteUser() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用UserDao中的方法
        userDao.deleteUser(10);

        // System.out.println("success");

        testFindAll();

    }

    /**
     * 查询所有用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用UserDao中的方法
        List<User> list = userDao.findAllUser();

        for (User user : list) {
            System.out.println(user);
        }

    }

    /**
     * 添加用户
     *
     * @throws Exception
     */
    @Test
    public void testInsertUser() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 构造参数信息;使用sqlSession添加用户
        User user = new User();
        user.setUsername("马化腾");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("深圳");

        userDao.insertUser(user);

        testFindAll();

    }

}
