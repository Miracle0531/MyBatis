package com.itheima.mybatis05.mapper;

import com.itheima.mybatis05.pojo.Orders;

import java.util.List;

/**
 * <p>Titel:OrderCustomMapper</p>
 * <p>Description:用户订单信息的一对一映射查询</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 18:35
 */
public interface OrderCustomMapper {

    /**
     * 使用resultMap进行一对一查询
     *
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersAndUserByResultMap() throws Exception;

    /**
     * 使用resultMap进行多对多查询
     *
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersAndOrderdetail() throws Exception;

    /**
     * 使用resultMap进行多对多查询
     *
     * @return
     * @throws Exception
     */
    public List<Orders> findUserAndItems() throws Exception;

    /**
     * 懒加载查询用户测试
     *
     * @return
     * @throws Exception
     */
    public List<Orders> findOrdersLazyLoadingUser() throws Exception;

}
