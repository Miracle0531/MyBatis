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
 * @time 2018-01-09 11:32
 */
@SuppressWarnings("all")
public interface UserMapper {

    /**
     * 查询指定用户
     *
     * @param queryUserVo
     * @return
     * @throws Exception
     */
    public List<User> findUserList(QueryUserVo queryUserVo) throws Exception;

    /**
     * 查询所有用户
     *
     * @return
     * @throws Exception
     */
    public List<User> findAllUser() throws Exception;

    /**
     * 删除指定用户
     *
     * @param id
     * @throws Exception
     */
    public void deleteUserById(String id) throws Exception;

    /**
     * 添加用户
     *
     * @param queryUserVo
     * @throws Exception
     */
    public void insertUser(QueryUserVo queryUserVo) throws Exception;

    /**
     * 修改用户
     *
     * @param queryUserVo
     * @throws Exception
     */
    public void updateUser(QueryUserVo queryUserVo) throws Exception;

}
