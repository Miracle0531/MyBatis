package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * <p>Titel:UserDaoImpl</p>
 * <p>Description:用户信息操作的逻辑实现类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-11 17:14
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    public User findUserById(int id) throws Exception {

        SqlSession sqlSession = this.getSqlSession();

        User user = sqlSession.selectOne("test.findUserById", id);

        return user;
    }

    public List<User> findUserByName(String name) throws Exception {
        return null;
    }

    public void insertUser(User user) throws Exception {

    }
}
