package com.itheima.mybatis03.mapper;

import com.itheima.mybatis03.pojo.QueryUserVo;
import com.itheima.mybatis03.pojo.User;

import java.util.List;

/**
 * <p>Titel:UserMapper</p>
 * <p>Description:用户信息mapper</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 15:56
 */
@SuppressWarnings("all")
public interface UserMapper {

    /**
     * 查询指定用户
     *
     * @return
     * @throws Exception
     */
    public List<User> findUserByName(QueryUserVo queryUserVo) throws Exception;

}
