package com.itheima.mybatis03.mapper;

import com.itheima.mybatis03.po.QueryUserVo;
import com.itheima.mybatis03.po.User;

import java.util.List;

/**
 * <p>Titel:UserMapperCustomer</p>
 * <p>Description:自定义用户的mapper</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 10:26
 */
@SuppressWarnings("all")
public interface UserMapperCustomer {

    /**
     * 查询制定用户列表
     *
     * @param queryUserVo
     * @return
     * @throws Exception
     */
    public List<User> findUserList(QueryUserVo queryUserVo) throws Exception;


}
