package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;

import java.util.List;

/**
 * <p>Titel:UserDao</p>
 * <p>Description:用户信息操作的逻辑接口</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 17:14
 */
@SuppressWarnings("all")
public interface UserDao {

    // 根据用户ID查询用户信息
    public User findUserById(int id) throws Exception;

    // 根据用户名称模糊查询
    public List<User> findUserByName(String name) throws Exception;

    // 添加用户
    public void insertUser(User user) throws Exception;

}
