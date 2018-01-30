package com.itheima.mybatis03.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 单独使用jdbc开发程序;总结问题
 *
 * @author TJR
 * @version 1.0
 * @time 2017-12-24 10:27
 */
public class JdbcTest {

    @Test
    public void test01() {

        // 连接数据库
        Connection connection = null;
        // 预编译statement,jdbc和数据库通过Statement进行通信,statement中封装了sql语句及参数
        PreparedStatement preparedStatement = null;
        // 结果集
        ResultSet resultSet = null;

        try {

            // 加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 通过驱动管理类获取数据库连接
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mybatis03?charsetEncoding=UTF-8",
                    "root",
                    "123456");
            // 定义SQL语句?表示占位符
            // 预编译statement:可以提高数据库的性能,使用占位符可以有效的防止sql注入攻击
            String sql = "select * from user where username = ?";
            // 获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            // 设置sql参数,第一个参数为sql语句中的参数的序号,第二个参数为设置的参数值
            preparedStatement.setString(1, "王五");
            // 向数据库发送SQL执行查询,查询结果集
            resultSet = preparedStatement.executeQuery();
            // 遍历结果集进行输出
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + "-" + resultSet.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
