package com.itheima.mybatis03.mapper;

import com.itheima.mybatis03.po.User;

import java.util.List;

/**
 * <p>Titel:UserMapper</p>
 * <p>Description:用户信息操作的Mapper代理</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-05 19:36
 */
@SuppressWarnings("all")
public interface UserMapper {

    // 根据用户ID查询用户信息
    public User findUserById(int id) throws Exception;

    // 查询所有用户
    public List<User> findAllUser() throws Exception;

    // 根据用户名进行模糊查询
    public List<User> findUserByUsername(String username) throws Exception;

    // 添加用户
    public void insertUser(User user) throws Exception;

    // 修改用户
    public void updateUser(User userww) throws Exception;

    // 删除用户
    public void deleteUser(int id) throws Exception;

}
