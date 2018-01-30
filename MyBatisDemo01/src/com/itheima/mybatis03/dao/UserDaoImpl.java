package com.itheima.mybatis03.dao;

import com.itheima.mybatis03.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * <p>Titel:UserDaoImpl</p>
 * <p>Description:用户管理的DAO实现类</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-05 14:40
 */
@SuppressWarnings("all")
public class UserDaoImpl implements UserDao {

    // 接口实现类中注入SqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    // 通过构造方法注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User findUserById(int id) throws Exception {

        // SqlSession定义为局部变量(防止线程不安全导致的数据的读取错误)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("test.findUserById", id);

        // 关闭会话
        sqlSession.close();

        return user;
    }

    /**
     * 根据用户名进行模糊查询
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findUserByName(String name) throws Exception {

        // SqlSession定义为局部变量(防止线程不安全导致的数据的读取错误)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findUserByUsername", name);

        // 关闭会话
        sqlSession.close();

        return list;
    }

    /**
     * 添加用户信息
     *
     * @param user
     * @throws Exception
     */
    @Override
    public void insertUser(User user) throws Exception {

        // SqlSession定义为局部变量(防止线程不安全导致的数据的读取错误)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("test.insertUser", user);
        // 提交添加用户
        sqlSession.commit();

        // 关闭会话
        sqlSession.close();

    }

    /**
     * 删除用户信息
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteUser(int id) throws Exception {

        // SqlSession定义为局部变量(防止线程不安全导致的数据的读取错误)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser", id);

        // 提交删除用户
        sqlSession.commit();

        // 关闭会话
        sqlSession.close();

    }

    /**
     * 查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findAllUser() throws Exception {

        // SqlSession定义为局部变量(防止线程不安全导致的数据的读取错误)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findAllUser");

        // 关闭会话
        sqlSession.close();

        return list;
    }
}
