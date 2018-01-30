package com.itheima.mybatis.test;

import com.itheima.mybatis.dao.UserDao;
import com.itheima.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Titel:UserDaoTest</p>
 * <p>Description:用户信息的测试类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 18:16
 */
@SuppressWarnings("all")
public class UserDaoTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        // 取出Spring容器
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception {

        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        User user = userDao.findUserById(1);

        System.out.println(user);

    }

}
