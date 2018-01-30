package com.itheima.mybatis.test;

import com.itheima.mybatis.mapper.UserMapper;
import com.itheima.mybatis.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * <p>Titel:UserMapperTest</p>
 * <p>Description:用户信息的mapper代理测试</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 19:22
 */
public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        //取出spring的容器
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {

        // 从applicationContext中取出UserMapper
        UserMapper userMap = (UserMapper) applicationContext.getBean("userMapper");

        User user = userMap.findUserById(1);

        System.out.println(user);

    }

}
