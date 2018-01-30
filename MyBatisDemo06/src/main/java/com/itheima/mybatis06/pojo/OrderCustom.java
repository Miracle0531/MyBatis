package com.itheima.mybatis06.pojo;

import java.io.Serializable;

/**
 * <p>Titel:OrderCustom</p>
 * <p>Description:自定义订单信息</p>
 *
 * @author TJR
 * @version 1.0
 * @time 2018-01-10 19:16
 */
public class OrderCustom implements Serializable {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
