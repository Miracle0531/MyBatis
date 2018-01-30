package com.itheima.mybatis06.mapper;

import com.itheima.mybatis06.pojo.User;

/**
 * <p>Titel:UserMapper</p>
 * <p>Description:用户信息的操作接口</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-21 21:34
 */
public interface UserMapper {

    /**
     * 根据ID查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(Integer id) throws Exception;

}
