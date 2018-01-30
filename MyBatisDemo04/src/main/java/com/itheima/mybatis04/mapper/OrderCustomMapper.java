package com.itheima.mybatis04.mapper;

import com.itheima.mybatis04.pojo.OrderCustom;

import java.util.List;

/**
 * <p>Titel:OrderCustomMapper</p>
 * <p>Description:自定义订单mapper</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-09 20:31
 */
@SuppressWarnings("all")
public interface OrderCustomMapper {

    /**
     * 查询指定信息的用户及订单信息
     *
     * @return
     * @throws Exception
     */
    public List<OrderCustom> findOrderAndUserByResultType() throws Exception;

}
