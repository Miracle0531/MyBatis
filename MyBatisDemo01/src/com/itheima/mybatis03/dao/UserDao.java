package com.itheima.mybatis03.dao;

import com.itheima.mybatis03.po.User;

import java.util.List;

/**
 * <p>Titel:UserDao</p>
 * <p>Description:用户管理的DAO</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-05 14:12
 */
public interface UserDao {

    // 根据用户ID查询用户信息
    public User findUserById(int id) throws Exception;

    // 根据用户名称模糊查询
    public List<User> findUserByName(String name) throws Exception;

    // 添加用户
    public void insertUser(User user) throws Exception;

    // 删除用户
    public void deleteUser(int id) throws Exception;

    // 查询所有用户信息
    public List<User> findAllUser() throws Exception;

}
