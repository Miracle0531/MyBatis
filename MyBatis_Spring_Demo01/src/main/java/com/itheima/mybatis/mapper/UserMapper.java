package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.User;

/**
 * <p>Titel:UserMapper</p>
 * <p>Description:用户信息操作mapper</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 19:07
 */
public interface UserMapper {

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(int id) throws Exception;

}
