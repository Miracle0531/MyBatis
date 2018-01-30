package com.itheima.mybatis05.mapper;

import com.itheima.mybatis05.pojo.User;

/**
 * <p>Titel:UserMapper</p>
 * <p>Description:用户信息的mapper</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 9:22
 */
@SuppressWarnings("all")
public interface UserMapper {

    /**
     * 查询指定ID的用户信息
     *
     * @return
     * @throws Exception
     */
    public User findUserList() throws Exception;

}
